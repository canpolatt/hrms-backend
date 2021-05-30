package hrms.management.business.abstracts;

import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getByActiveStatusTrue();
    DataResult<List<JobAdvertisement>> getAllSortedByOldestDate();
    DataResult<List<JobAdvertisement>> getAllSortedByNewestDate();

    Result add(JobAdvertisement jobAdvertisement);
    Result delete(JobAdvertisement jobAdvertisement);
    Result update(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>>getByEmployer_IdAndActiveStatusTrue(Integer employerId);


}
