package hrms.management.entities.concretes;


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
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(targetEntity = CurriculumVitae.class)
    @JoinColumn(name="curriculum_vitae_id")
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
