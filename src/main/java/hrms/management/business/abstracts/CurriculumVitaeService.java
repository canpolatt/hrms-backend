package hrms.management.business.abstracts;

import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.CurriculumVitae;
import hrms.management.entities.concretes.School;

import java.util.List;

public interface CurriculumVitaeService {
    DataResult<List<CurriculumVitae>> getAll();
    Result add(CurriculumVitae curriculumVitae);

}
