package hrms.management.business.concretes;
import hrms.management.business.abstracts.CandidateService;
import hrms.management.core.adapters.abstracts.MernisCheckService;
import hrms.management.core.utilities.imageUploaders.ImageService;
import hrms.management.core.utilities.results.*;
import hrms.management.dataAccess.abstracts.CandidateDao;
import hrms.management.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private MernisCheckService mernisCheckService;
    private ImageService imageService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, MernisCheckService mernisCheckService,ImageService imageService) {
        this.candidateDao = candidateDao;
        this.mernisCheckService = mernisCheckService;
        this.imageService=imageService;
    }


    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Job title listelendi");
    }

    @Override
    public Result add(Candidate candidate) {
        Result result = RunRules.run(identityNumberControl(candidate),mernisControl(candidate),nullControl(candidate));
        if(result.isSuccess()){
            candidateDao.save(candidate);
            return new SuccessResult(candidate.getFirstName()+ " "+ candidate.getLastName()+" eklendi.");
        }
        return result;
    }

    @Override
    public DataResult<Candidate> imageUpload(int candidateId, MultipartFile file) throws IOException{
        var candidate=this.candidateDao.getById(candidateId);
        var imageUrl=uploadImageToCloudinary(file,candidate.getImageUrl());
        var result=RunRules.run(checkCandidateExists(candidate));
        if(!result.isSuccess()){
            return new ErrorDataResult<>(null,result.getMessage());
        }
        if (!imageUrl.isSuccess()){
            return new ErrorDataResult<>(null, imageUrl.getMessage());
        }
        candidate.setImageUrl(imageUrl.getMessage());
        return new SuccessDataResult<>(this.candidateDao.save(candidate));
    }

//------------------------------------------------------------------------------------------------------------------

    private Result mernisControl(Candidate candidate) {
        if (!mernisCheckService.checkIfRealPerson(candidate)) {
            return new ErrorResult("Mernis dogrulamamasi gerceklesemedi");
        }
        return new SuccessResult();
    }

    private  Result uploadImageToCloudinary( MultipartFile file, String imageUrl) throws IOException {
        var result = this.imageService.upload(file);
        if(!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        if(imageUrl != null){
            var imageId = imageUrl.split(("/"))[imageUrl.split(("/")).length - 1].split("\\.")[0];
            this.imageService.delete(imageId);
        }
        var url = result.getData().get("url");
        return new SuccessResult(url.toString());
    }
    private Result identityNumberControl(Candidate candidate) {

        if (candidate.getIdentificationNumber().length() != 11) {
            return new ErrorResult("TC numarasi 11 haneli olmalidir.");
        }
        return new SuccessResult();
    }
    private Result checkCandidateExists(Candidate candidate){
        if (candidate == null){
            return new ErrorResult("Candidate doesn't exists");
        }
        return  new SuccessResult();
    }

    private Result nullControl(Candidate candidate) {
        if(candidate.getFirstName().isEmpty()||
                candidate.getLastName().isEmpty()||
                candidate.getIdentificationNumber().isEmpty()||
                candidate.getBirthDate().toString().isEmpty()||
                candidate.getEmail().isEmpty()||
                candidate.getPassword().isEmpty()){
            return new ErrorResult("Alanlar bos birakilamaz!!");
        }
        return new SuccessResult();
    }
}
