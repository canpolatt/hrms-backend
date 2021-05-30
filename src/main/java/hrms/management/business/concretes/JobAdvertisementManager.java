package hrms.management.business.concretes;

import hrms.management.business.abstracts.JobAdvertisementService;
import hrms.management.core.utilities.results.*;
import hrms.management.dataAccess.abstracts.JobAdvertisementDao;
import hrms.management.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Tum ilanlar listelendi...");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActiveStatusTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveStatusTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSortedByOldestDate() {
        Sort sort=Sort.by(Sort.Direction.DESC,"creationDate");
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveStatusTrue(sort),"Listelendi..");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSortedByNewestDate() {
        Sort sort=Sort.by(Sort.Direction.ASC,"creationDate");
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveStatusTrue(sort),"Listelendi..");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Is ilani "+jobAdvertisement.getCreationDate()+" tarihinde eklendi.");
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult("Is ilani silindi..");
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Is ilani guncellendi..");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEmployer_IdAndActiveStatusTrue(Integer employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_IdAndActiveStatusTrue(employerId));
    }

}
