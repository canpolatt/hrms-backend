package hrms.management.business.concretes;

import hrms.management.business.abstracts.SchoolService;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.core.utilities.results.SuccessDataResult;
import hrms.management.core.utilities.results.SuccessResult;
import hrms.management.dataAccess.abstracts.SchoolDao;
import hrms.management.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }


    @Override
    public DataResult<List<School>> getAll() {
        Sort sort=Sort.by(Sort.Direction.DESC,"finishDate");
        return new SuccessDataResult<>(this.schoolDao.findAll(sort));
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Eklendi!!");
    }
}
