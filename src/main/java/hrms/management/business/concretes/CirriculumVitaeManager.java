package hrms.management.business.concretes;

import hrms.management.business.abstracts.CurriculumVitaeService;
import hrms.management.core.utilities.results.*;
import hrms.management.dataAccess.abstracts.CurriculumVitaeDao;
import hrms.management.dataAccess.abstracts.SchoolDao;
import hrms.management.entities.concretes.CurriculumVitae;
import hrms.management.entities.concretes.JobExperience;
import hrms.management.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirriculumVitaeManager implements CurriculumVitaeService {
    private CurriculumVitaeDao curriculumVitaeDao;

    @Autowired
    public CirriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(this.curriculumVitaeDao.findAll());
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        this.curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult("Eklendi!!");
    }

}
