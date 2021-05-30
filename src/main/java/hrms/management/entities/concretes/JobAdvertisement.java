package hrms.management.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name="job_advertisement")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JoinColumn(name="employer_id")
    @ManyToOne()
    private Employer employer;

    @NotNull
    @JoinColumn(name="job_position_id")
    @ManyToOne()
    private JobTitle jobTitle;

    @NotNull
    @JoinColumn(name="city_id")
    @ManyToOne()
    private City city;

    @NotBlank
    @Column(name="job_description")
    private String jobDescription;

    @PositiveOrZero
    @Column(name="min_salary")
    private int minSalary;

    @PositiveOrZero
    @Column(name="max_salary")
    private int maxSalary;

    @Positive
    @Column(name="number_of_open_positions")
    private int numberOfOpenPositions;

    @Future
    @Column(name="deadline")
    private LocalDate deadline;

    @PastOrPresent
    @Column(name="creation_date")
    private final LocalDate creationDate=LocalDate.now();

    @Column(name="is_active")
    private boolean activeStatus;



}
