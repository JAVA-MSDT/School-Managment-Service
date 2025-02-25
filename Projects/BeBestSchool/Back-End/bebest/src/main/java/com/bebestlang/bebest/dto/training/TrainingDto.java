package com.bebestlang.bebest.dto.training;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import com.bebestlang.bebest.modal.training.TrainingMode;
import com.bebestlang.bebest.modal.training.TrainingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(description = "Training Dto object")
public class TrainingDto {

    @ApiModelProperty(value = "Training id", example = "UUID4")
    private String id;

    @ApiModelProperty(value = "Training Title", example = "Arabic, Polish, English, etc")
    private String title;

    @ApiModelProperty(value = "Training Subject Id", example = "Arabic, Polish, English, etc")
    private String subjectId;

    @ApiModelProperty(value = "Training Teacher Id", example = "Ania Kania, etc")
    private String teacherId;

    @ApiModelProperty(value = "Training Students Ids", example = "[studentIdOne, StudentIdTwo, etc]", notes = "Set of students ids participating in the training")
    private Set<String> studentsIds;

    @ApiModelProperty(value = "Training starting date", example = "2021-01-25")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startingDate;

    @ApiModelProperty(value = "Training end date", example = "2021-04-25")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @ApiModelProperty(value = "Training mode", example = "ON_SITE, ONLINE or MIXED")
    private TrainingMode trainingModes;

    @ApiModelProperty(value = "Training status", example = "PROMOTED, STARTED, DONE or ARCHIVED")
    private TrainingStatus trainingStatus;

    @ApiModelProperty(value = "Training description", example = "\"description\": {\n" +
            "\"EN\": \"English Description\",\n" +
            "\"PL\": \"Polish Description\"\n" +
            "}",
            notes = "Map object, Key is the Language shortcut & Value is the description in that language ")
    private Map<String, String> description;
}
