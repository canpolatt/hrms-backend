package hrms.management.business.concretes;

import hrms.management.business.abstracts.CurriculumVitaeService;
import hrms.management.core.utilities.results.*;
import hrms.management.dataAccess.abstracts.CurriculumVitaeDao;
import hrms.management.dataAccess.abstracts.ForeignLanguageDao;
import hrms.management.dataAccess.abstracts.JobExperienceDao;
import hrms.management.dataAccess.abstracts.SchoolDao;
import hrms.management.entities.concretes.CurriculumVitae;
import hrms.management.entities.concretes.ForeignLanguage;
import hrms.management.entities.concretes.JobExperience;
import hrms.management.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirriculumVitaeManager implements CurriculumVitaeService {
    private CurriculumVitaeDao curriculumVitaeDao;
    private SchoolDao schoolDao;
    private JobExperienceDao jobExperienceDao;
    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public CirriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, SchoolDao schoolDao, JobExperienceDao jobExperienceDao, ForeignLanguageDao foreignLanguageDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
        this.schoolDao = schoolDao;
        this.jobExperienceDao = jobExperienceDao;
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(this.curriculumVitaeDao.findAll());
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        CurriculumVitae tempCv= curriculumVitaeDao.save(curriculumVitae);
        setCvSchoolId(tempCv.getSchools(),tempCv);
        setCvExperienceId(tempCv.getJobExperiences(),tempCv);
        setCvLanguageId(tempCv.getForeignLanguages(),tempCv);
        return new SuccessResult("Eklendi!!");
    }


    private void setCvSchoolId(List<School> schools,CurriculumVitae cv){
        for(School school:schools){
            school.setCurriculumVitae(cv);
            schoolDao.save(school);
        }
    }
    private void setCvExperienceId(List<JobExperience> experiences,CurriculumVitae cv){
        for(JobExperience experience:experiences){
            experience.setCurriculumVitae(cv);
            jobExperienceDao.save(experience);
        }
    }

    private void setCvLanguageId(List<ForeignLanguage> languages, CurriculumVitae cv){
        for(ForeignLanguage language:languages){
            language.setCurriculumVitae(cv);
            foreignLanguageDao.save(language);
        }
    }

}
