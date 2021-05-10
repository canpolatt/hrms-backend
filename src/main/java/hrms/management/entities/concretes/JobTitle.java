package hrms.management.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="job_titles")
@Data
public class JobTitle {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String job_title;
}
