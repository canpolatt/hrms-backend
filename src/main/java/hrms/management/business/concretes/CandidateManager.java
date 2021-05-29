package hrms.management.business.concretes;
import hrms.management.business.abstracts.CandidateService;
import hrms.management.core.adapters.abstracts.MernisCheckService;
import hrms.management.core.utilities.results.*;
import hrms.management.dataAccess.abstracts.CandidateDao;
import hrms.management.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private MernisCheckService mernisCheckService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, MernisCheckService mernisCheckService) {
        this.candidateDao = candidateDao;
        this.mernisCheckService = mernisCheckService;
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

//------------------------------------------------------------------------------------------------------------------

    private Result mernisControl(Candidate candidate) {
        if (!mernisCheckService.checkIfRealPerson(candidate)) {
            return new ErrorResult("Mernis dogrulamamasi gerceklesemedi");
        }
        return new SuccessResult();
    }
    private Result identityNumberControl(Candidate candidate) {

        if (candidate.getIdentificationNumber().length() != 11) {
            return new ErrorResult("TC numarasi 11 haneli olmalidir.");
        }
        return new SuccessResult();
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
