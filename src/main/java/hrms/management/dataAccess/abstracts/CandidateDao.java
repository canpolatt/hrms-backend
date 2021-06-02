package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    Candidate getById(int id);

}
