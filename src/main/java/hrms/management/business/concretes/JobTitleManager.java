package hrms.management.business.concretes;

import hrms.management.business.abstracts.JobTitleService;
import hrms.management.core.utilities.results.*;
import hrms.management.dataAccess.abstracts.JobTitleDao;
import hrms.management.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {
    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        super();
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Job title listelendi"); // DataResult super type base oldugu icin ikisinide tutuyor

    }

    @Override
    public Result add(JobTitle jobTitle) {
        Result result=RunRules.run(nullControl(jobTitle),titleRepeatControl(jobTitle));
        if(result.isSuccess()){
            this.jobTitleDao.save(jobTitle);
            return new SuccessResult(jobTitle.getJobTitle()+" eklendi..");
        }
       return result;
    }

    //-----------------------------------------------------------------------------------------------------------------

    private Result nullControl(JobTitle jobTitle) {
        if(jobTitle.getJobTitle()==null || jobTitle.getJobTitle().isBlank()) {
            return new ErrorResult("Alanlar bos birakilamaz!!!");
        }
        return new SuccessResult();
    }

    private Result titleRepeatControl(JobTitle jobTitle) {
        if((long) jobTitleDao.findAllByJobTitle(jobTitle.getJobTitle()).size() !=0 ) {
            return new ErrorResult("Bu pozisyon mevcut!!!");
        }
        return new SuccessResult();
    }
}
