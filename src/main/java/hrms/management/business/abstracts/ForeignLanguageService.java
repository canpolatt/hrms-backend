package hrms.management.business.abstracts;

import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    DataResult<List<ForeignLanguage>> getAll();
    Result add(ForeignLanguage foreignLanguage);
}
