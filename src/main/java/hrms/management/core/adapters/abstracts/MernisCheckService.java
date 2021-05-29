package hrms.management.core.adapters.abstracts;

import hrms.management.entities.concretes.Candidate;

public interface MernisCheckService {
    boolean checkIfRealPerson(Candidate candidate);
}
