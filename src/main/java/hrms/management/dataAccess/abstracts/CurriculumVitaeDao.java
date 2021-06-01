package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae,Integer> {
}
