package com.school.management.modal.training;

import java.time.LocalDateTime;
import java.util.Set;

import com.school.management.modal.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "training_enrollment")
@Entity
public class TrainingEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "training_id")
    private Training training;

    @Column(name = "ending_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime trainingTime;

    @OneToMany(targetEntity = User.class)
    private Set<User> dailyStudentAttendance;

}
