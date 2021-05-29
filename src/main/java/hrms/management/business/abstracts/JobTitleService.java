package hrms.management.business.abstracts;

import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    DataResult<List<JobTitle>> getAll(); //Islem basarili mi basarisiz mi bilmiyoruz , DataResult donduruyoruz yani tek basina veri degil basarili mi
    //basarisiz mi , mesaj , veri gibi seyler donduruyoruz, datanin turunu List of Jobtitle sectik

    Result add(JobTitle jobTitle);
}
