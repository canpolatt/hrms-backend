package hrms.management.business.abstracts;

import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();
    Result add(JobExperience jobExperience);
}
