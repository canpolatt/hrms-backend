package hrms.management.business.abstracts;

import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.Result;
import hrms.management.entities.concretes.Candidate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    Result add(Candidate candidate);
    DataResult<Candidate> imageUpload(int candidateId, MultipartFile file) throws IOException;
}
