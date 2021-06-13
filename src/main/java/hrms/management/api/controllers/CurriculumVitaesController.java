package hrms.management.api.controllers;

import hrms.management.business.abstracts.CurriculumVitaeService;
import hrms.management.core.utilities.results.ErrorDataResult;
import hrms.management.core.utilities.results.ErrorResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.core.utilities.results.SuccessResult;
import hrms.management.entities.concretes.CurriculumVitae;
import hrms.management.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/cvs")
@CrossOrigin
public class CurriculumVitaesController {
    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result = this.curriculumVitaeService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getByCandidate")
    public ResponseEntity<?> getByCandidate(@RequestParam int id){
        var result = this.curriculumVitaeService.getByCandidate_CandidateId(id);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CurriculumVitae curriculumVitae){
        var result = this.curriculumVitaeService.add(curriculumVitae);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }

}
