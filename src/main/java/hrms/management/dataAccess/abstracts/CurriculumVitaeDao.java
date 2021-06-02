package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae,Integer> {
    List<CurriculumVitae> getByCandidate_Id(int candidateId);

}
