package hrms.management.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(targetEntity = CurriculumVitae.class)
    @JoinColumn(name="curriculum_vitae_id",referencedColumnName =  "id" ,nullable = false)
    private CurriculumVitae curriculumVitae;

    @Column(name="workplace_name")
    private String workplaceName;

    @Column(name="position")
    private String position;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="finish_date")
    private LocalDate finishDate;




}
