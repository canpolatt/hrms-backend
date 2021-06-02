package hrms.management.business.concretes;

import hrms.management.business.abstracts.CurriculumVitaeService;
import hrms.management.business.abstracts.ForeignLanguageService;
import hrms.management.business.abstracts.JobExperienceService;
import hrms.management.business.abstracts.SchoolService;
import hrms.management.core.utilities.imageUploaders.ImageService;
import hrms.management.core.utilities.results.*;
import hrms.management.dataAccess.abstracts.CurriculumVitaeDao;
import hrms.management.dataAccess.abstracts.ForeignLanguageDao;
import hrms.management.dataAccess.abstracts.JobExperienceDao;
import hrms.management.dataAccess.abstracts.SchoolDao;
import hrms.management.entities.concretes.CurriculumVitae;
import hrms.management.entities.concretes.ForeignLanguage;
import hrms.management.entities.concretes.JobExperience;
import hrms.management.entities.concretes.School;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class CirriculumVitaeManager implements CurriculumVitaeService {
    private final CurriculumVitaeDao curriculumVitaeDao;
    private  final SchoolService schoolService;
    private  final JobExperienceService jobExperienceService;
    private  final ForeignLanguageService foreignLanguageService;



    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(this.curriculumVitaeDao.findAll());
    }

    @Override
    public DataResult<List<CurriculumVitae>> getByCandidate_CandidateId(int candidateId) {
        return new SuccessDataResult<>(this.curriculumVitaeDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        for(School school:curriculumVitae.getSchools()){
            school.setCurriculumVitae(curriculumVitae);
            schoolService.add(school);
        }
        for(JobExperience jobExperience:curriculumVitae.getJobExperiences()){
            jobExperience.setCurriculumVitae(curriculumVitae);
            jobExperienceService.add(jobExperience);
        }

        for(ForeignLanguage foreignLanguage:curriculumVitae.getForeignLanguages()){
            foreignLanguage.setCurriculumVitae(curriculumVitae);
            foreignLanguageService.add(foreignLanguage);
        }
        return new SuccessResult("Eklendi!!");
    }

}
