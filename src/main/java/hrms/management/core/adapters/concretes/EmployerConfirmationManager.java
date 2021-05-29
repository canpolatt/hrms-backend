package hrms.management.core.adapters.concretes;

import hrms.management.core.adapters.abstracts.EmployerConfirmationService;
import hrms.management.core.utilities.results.Result;
import hrms.management.core.utilities.results.SuccessResult;

public class EmployerConfirmationManager implements EmployerConfirmationService {
    @Override
    public Result confirmEmployer(int employerID) {
        return new SuccessResult("Employer onaylandi");
    }
}
