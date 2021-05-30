package hrms.management.api.controllers;

import hrms.management.business.abstracts.JobAdvertisementService;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAll")
    DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getByActiveStatusTrue")
    DataResult<List<JobAdvertisement>> getByActiveStatusTrue(){
        return this.jobAdvertisementService.getByActiveStatusTrue();
    }

    @GetMapping("/getAllSortedByOldestDate")
    DataResult<List<JobAdvertisement>> getAllSortedByOldestDate(){
        return this.jobAdvertisementService.getAllSortedByOldestDate();
    }

    @GetMapping("/getAllSortedByNewestDate")
    DataResult<List<JobAdvertisement>> getAllSortedByNewestDate(){
        return this.jobAdvertisementService.getAllSortedByNewestDate();
    }

    @GetMapping("/getByEmployer_IdAndActiveStatusTrue")
    DataResult<List<JobAdvertisement>>getByEmployer_IdAndActiveStatusTrue(@RequestParam Integer employerId){
        return this.jobAdvertisementService.getByEmployer_IdAndActiveStatusTrue(employerId);
    }

    @PostMapping("/add")
    Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }

    @DeleteMapping("/delete")
    Result delete(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.delete(jobAdvertisement);
    }

    @PutMapping("/update")
    Result update(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.update(jobAdvertisement);
    }

}
