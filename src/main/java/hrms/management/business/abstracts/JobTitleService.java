package hrms.management.business.abstracts;

import hrms.management.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    List<JobTitle> getAll();
}
