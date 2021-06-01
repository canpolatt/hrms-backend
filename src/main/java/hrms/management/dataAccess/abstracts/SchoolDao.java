package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School,Integer> {
}
