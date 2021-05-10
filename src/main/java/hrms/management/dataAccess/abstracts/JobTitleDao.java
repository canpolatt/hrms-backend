package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
}
