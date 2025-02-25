package com.school.management.modal.training;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.school.management.modal.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "training")
@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private User teacherId;

    @OneToMany(targetEntity = User.class)
    private Set<User> studentsIds;

    @Column(name = "starting_date",columnDefinition = "DATE")
    private LocalDate startingDate;

    @Column(name = "ending_date", columnDefinition = "DATE")
    private LocalDate endingDate;

    @Enumerated(EnumType.STRING)
    private TrainingMode trainingMode;

    @Enumerated(EnumType.STRING)
    private TrainingStatus trainingStatus;

    @ElementCollection
    private Map<String, String> description;

    @OneToMany(targetEntity = TrainingEnrollment.class)
    private Set<TrainingEnrollment> trainingEnrollments = new HashSet<>();

}
