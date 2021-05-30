package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> getByActiveStatusTrue();
    List<JobAdvertisement> getByActiveStatusTrue(Sort sort);
    List<JobAdvertisement> getByEmployer_IdAndActiveStatusTrue(Integer employerId);
}
