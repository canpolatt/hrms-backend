package hrms.management.core.adapters.abstracts;

import hrms.management.core.utilities.results.Result;

public interface EmployerConfirmationService {
    Result confirmEmployer(int employerId);
}
