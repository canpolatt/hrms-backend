package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
   List<Employer> findAllByEmail(String email);

}
