package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {
}
