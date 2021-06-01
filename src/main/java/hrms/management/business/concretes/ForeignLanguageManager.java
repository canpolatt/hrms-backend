package hrms.management.business.concretes;

import hrms.management.business.abstracts.ForeignLanguageService;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.core.utilities.results.SuccessDataResult;
import hrms.management.core.utilities.results.SuccessResult;
import hrms.management.dataAccess.abstracts.ForeignLanguageDao;
import hrms.management.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<>(this.foreignLanguageDao.findAll());
    }

    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult("Eklendi!!");
    }
}
