package hrms.management.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="schools")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="curriculum_vitae_id")
    @JsonIgnore
    private CurriculumVitae curriculumVitae;


    @Column(name="school_name")
    private String schoolName;

    @Column(name="department")
    private String department;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="finish_date")
    private LocalDate finishDate;



}
