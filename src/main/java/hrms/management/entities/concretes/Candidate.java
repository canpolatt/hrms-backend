package hrms.management.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hrms.management.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Candidate extends User {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="identity_number")
    private String identificationNumber;

    @Column(name="date_of_birth")
    private Date birthDate;

}
