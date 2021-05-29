package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
    List<JobTitle> findAllByJobTitle(String jobtitle);
}
