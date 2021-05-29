package hrms.management.core.adapters.abstracts;

import hrms.management.core.utilities.results.Result;

public interface EmailService {
    //Result confirmMail(int employerid);
    boolean emailSend(String email);
}
