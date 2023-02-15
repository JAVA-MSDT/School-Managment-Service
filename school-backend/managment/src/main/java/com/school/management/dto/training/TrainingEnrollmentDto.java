package com.school.management.dto.training;

import java.time.LocalDateTime;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Training Enrollment Dto object")
public class TrainingEnrollmentDto {

    @ApiModelProperty(value = "Training Enrollment id", example = "UUID4")
    private Long id;

    @ApiModelProperty(value = "Training id", example = "UUID4")
    private String trainingId;

    @ApiModelProperty(value = "Training running tile", example = "2022-10-25T16:00:00")
    private LocalDateTime trainingTime;

    @ApiModelProperty(value = "Training Attendance", example = "[studentIdOne, StudentIdTwo, etc]", notes = "students who are attending the training that time")
    private Set<String> dailyStudentAttendance;
}
