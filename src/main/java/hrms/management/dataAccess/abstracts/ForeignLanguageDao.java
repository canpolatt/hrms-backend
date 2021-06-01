package hrms.management.dataAccess.abstracts;

import hrms.management.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer>  {
}
