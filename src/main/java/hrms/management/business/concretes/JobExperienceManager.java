package hrms.management.business.concretes;

import hrms.management.business.abstracts.JobExperienceService;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.core.utilities.results.SuccessDataResult;
import hrms.management.core.utilities.results.SuccessResult;
import hrms.management.dataAccess.abstracts.JobExperienceDao;
import hrms.management.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }


    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<>(this.jobExperienceDao.findAll());
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Eklendi!!");
    }
}
