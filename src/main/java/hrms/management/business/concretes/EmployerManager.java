package hrms.management.business.concretes;

import hrms.management.business.abstracts.EmployerService;
import hrms.management.core.adapters.abstracts.EmailService;
import hrms.management.core.utilities.results.*;
import hrms.management.dataAccess.abstracts.EmployerDao;
import hrms.management.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmailService emailService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService emailService) {
        this.employerDao = employerDao;
        this.emailService = emailService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Employer listelendi.");
    }

    @Override
    public Result add(Employer employer) {
        Result result= RunRules.run(emailExist(employer.getEmail()),nullControl(employer),isRealEmployer(employer));
        if(result.isSuccess()){
            employerDao.save(employer);
            return new SuccessResult(employer.getCompanyName()+" eklendi..");
        }
        return result;
    }

//-----------------------------------------------------------------------------------------------------------------------
    private Result emailExist(String email) {
        if((long) employerDao.findAllByEmail(email).size() != 0) {
            return new ErrorResult("Email sistemde zaten mevcut!!");
        }
        return new SuccessResult();
    }
    private Result nullControl(Employer employer) {
        if(employer.getEmail()==null || employer.getEmail().isBlank()||
                employer.getPassword()==null||employer.getPassword().isBlank()||
                employer.getCompanyName()==null|| employer.getCompanyName().isBlank()||
                employer.getWebAddress()==null||employer.getWebAddress().isBlank()) {

            return new ErrorResult("Alanlar bos birakilamaz!!");
        }
        return new SuccessResult();
    }
    private Result isRealEmployer(Employer employer) {

        if(!emailService.emailSend(employer.getEmail())){
            return new ErrorResult("Email formatina uygun bir mail giriniz!!");
        }

        else if(!employer.getWebAddress().contains(employer.getEmail().split("@")[0])){
            return new ErrorResult("Domain ayni degil!!!");
        }
        return new SuccessResult();
    }
}
