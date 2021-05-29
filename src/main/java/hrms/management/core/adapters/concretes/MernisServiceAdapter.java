package hrms.management.core.adapters.concretes;

import hrms.management.MernisService.NRWKPSPublicSoap;
import hrms.management.core.adapters.abstracts.MernisCheckService;
import hrms.management.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MernisServiceAdapter implements MernisCheckService {
    @Override
    public boolean checkIfRealPerson(Candidate candidate) {
        int year=candidate.getBirthDate().getYear()+1900;
        NRWKPSPublicSoap soapClient=new NRWKPSPublicSoap();
        try{
            return soapClient.TCKimlikNoDogrula(Long.valueOf(candidate.getIdentificationNumber()),candidate.getFirstName().toUpperCase(),candidate.getLastName().toUpperCase(),year);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
