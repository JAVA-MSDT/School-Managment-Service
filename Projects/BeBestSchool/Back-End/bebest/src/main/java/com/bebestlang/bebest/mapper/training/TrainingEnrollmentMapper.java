package com.bebestlang.bebest.mapper.training;

import com.bebestlang.bebest.dto.training.TrainingEnrollmentDto;
import com.bebestlang.bebest.modal.training.TrainingEnrollment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingEnrollmentMapper {

    TrainingEnrollment toTrainingEnrollment(TrainingEnrollmentDto trainingEnrollmentDto);

    TrainingEnrollmentDto toTrainingEnrollmentDto(TrainingEnrollment trainingEnrollment);
}
