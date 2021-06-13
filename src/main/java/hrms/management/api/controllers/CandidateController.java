package hrms.management.api.controllers;

import hrms.management.business.abstracts.CandidateService;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {
    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result=this.candidateService.getAll();
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?>  add(@RequestBody Candidate candidate) {
        var result=this.candidateService.add(candidate);
        if(!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("uploadImage")
    public ResponseEntity<?> uploadImage(@RequestParam int candidateId, @RequestParam MultipartFile file){
        DataResult result = null ;
        try {
            result = this.candidateService.imageUpload(candidateId,file);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }
}
