package hrms.management.EmailVerification;

import hrms.management.entities.concretes.Employer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSender {
    public boolean emailVerification(String  email){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        //Regex to restrict no. of characters in top level domain [Recommended]
        //Source : https://howtodoinjava.com/java/regex/java-regex-validate-email-address/

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
