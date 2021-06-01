package hrms.management.api.controllers;

import hrms.management.business.abstracts.JobAdvertisementService;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll(){
        var result=this.jobAdvertisementService.getAll();
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getByActiveStatusTrue")
    public ResponseEntity<?>  getByActiveStatusTrue(){
        var result=this.jobAdvertisementService.getByActiveStatusTrue();
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllSortedByOldestDate")
    public ResponseEntity<?>  getAllSortedByOldestDate(){
        var result=this.jobAdvertisementService.getAllSortedByOldestDate();
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllSortedByNewestDate")
    public ResponseEntity<?> getAllSortedByNewestDate(){
        var result=this.jobAdvertisementService.getAllSortedByNewestDate();
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getByEmployer_IdAndActiveStatusTrue")
    public ResponseEntity<?>getByEmployer_IdAndActiveStatusTrue(@RequestParam Integer employerId){
        var result=this.jobAdvertisementService.getByEmployer_IdAndActiveStatusTrue(employerId);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobAdvertisement jobAdvertisement){
        var result=this.jobAdvertisementService.add(jobAdvertisement);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody JobAdvertisement jobAdvertisement){
        var result=this.jobAdvertisementService.delete(jobAdvertisement);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody JobAdvertisement jobAdvertisement){
        var result=this.jobAdvertisementService.update(jobAdvertisement);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

}
