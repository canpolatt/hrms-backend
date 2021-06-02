package hrms.management.business.abstracts;

import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.CurriculumVitae;
import hrms.management.entities.concretes.School;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CurriculumVitaeService {
    DataResult<List<CurriculumVitae>> getAll();
    DataResult<List<CurriculumVitae>> getByCandidate_CandidateId(int candidateId);
    Result add(CurriculumVitae curriculumVitae);

}
