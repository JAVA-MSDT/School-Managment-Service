package com.bebestlang.bebest.modal.training;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "training_enrollment")
public class TrainingEnrollment {

    @Id
    private String id;

    private String trainingId;

    private LocalDateTime trainingTime;

    private Set<String> dailyStudentAttendance;

}
