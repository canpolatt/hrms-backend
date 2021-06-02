package hrms.management.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="curriculum_vitaes")
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column(name="github_address")
    private String githubAddress;

    @Column(name="linkedin_address")
    private String linkedinAddress;

    @Column(name="skills")
    private String skills;

    @Column(name="cover_letter")
    private String coverLetter;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<JobExperience> jobExperiences;

   @OneToMany(mappedBy = "curriculumVitae")
    private List<School> schools;

    @OneToMany(mappedBy = "curriculumVitae")
    private List<ForeignLanguage> foreignLanguages;



}
