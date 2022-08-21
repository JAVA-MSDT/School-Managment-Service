package com.bebestlang.bebest.mapper.training;

import com.bebestlang.bebest.dto.training.TrainingDto;
import com.bebestlang.bebest.modal.training.Training;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingMapper {

    Training toTraining(TrainingDto trainingDto);

    TrainingDto toTrainingDto(Training training);
}
