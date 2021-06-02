package hrms.management.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="foreign_languages")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class ForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="curriculum_vitae_id")
    @JsonIgnore
    private CurriculumVitae curriculumVitae;

    @Column(name="language")
    private String language;

    @Column(name="level")
    private int level;


}
