package com.bebestlang.bebest.modal.training;

import java.time.LocalDate;
import java.util.Map;
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
@Document(collection = "training")
public class Training {

    @Id
    private String id;

    private String title;

    private String subjectId;

    private String teacherId;

    private Set<String> studentsIds;

    private LocalDate startingDate;

    private LocalDate endDate;

    private TrainingMode trainingModes;

    private TrainingStatus trainingStatus;

    private Map<String, String> description;

    private Set<TrainingEnrollment> trainingEnrollments;

}
