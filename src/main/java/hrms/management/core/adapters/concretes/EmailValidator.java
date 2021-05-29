package hrms.management.core.adapters.concretes;

import hrms.management.EmailVerification.EmailSender;
import hrms.management.core.adapters.abstracts.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements EmailService {

    EmailSender emailSender=new EmailSender();

    @Override
    public boolean emailSend(String email) {
        return emailSender.emailVerification(email);
    }
}
