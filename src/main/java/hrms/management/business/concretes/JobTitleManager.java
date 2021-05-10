package hrms.management.business.concretes;

import hrms.management.business.abstracts.JobTitleService;
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
    public List<JobTitle> getAll() {
        return this.jobTitleDao.findAll();
    }
}
