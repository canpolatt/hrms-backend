package hrms.management.api.controllers;

import hrms.management.business.abstracts.JobTitleService;
import hrms.management.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<JobTitle> getAll(){
        return this.jobTitleService.getAll();
    }
}
