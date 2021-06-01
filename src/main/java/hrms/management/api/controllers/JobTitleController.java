package hrms.management.api.controllers;

import hrms.management.business.abstracts.JobTitleService;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitleController {
    private JobTitleService jobTitleService;

    @Autowired
    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result=this.jobTitleService.getAll();
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobTitle jobTitle){
        var result=this.jobTitleService.add(jobTitle);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
