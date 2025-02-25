package com.bebestlang.bebest.service.training;

import com.bebestlang.bebest.dto.training.TrainingDto;
import com.bebestlang.bebest.exception.training.TrainingException;
import com.bebestlang.bebest.mapper.training.TrainingMapper;
import com.bebestlang.bebest.repository.training.TrainingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    private final TrainingMapper trainingMapper;

    public Mono<TrainingDto> findTrainingById(String id) {
        return trainingRepository.findById(id)
                .switchIfEmpty(Mono.error(new TrainingException(String.format("Training with Id:: %s not found ", id),
                        HttpStatus.NOT_FOUND)))
                .map(trainingMapper::toTrainingDto);
    }

    public Flux<TrainingDto> findAllTraining() {
        return trainingRepository.findAll()
                .map(trainingMapper::toTrainingDto);
    }

    public Mono<TrainingDto> saveTraining(TrainingDto trainingDto) {
        return trainingRepository.save(trainingMapper.toTraining(trainingDto))
                .map(trainingMapper::toTrainingDto);
    }

    public Mono<TrainingDto> updateTraining(TrainingDto trainingDto, String id) {
        return findTrainingById(id)
                .flatMap(returnedTrainingDto -> getValidTrainingDto(returnedTrainingDto, trainingDto))
                .flatMap(this::saveTraining);
    }

    private Mono<TrainingDto> getValidTrainingDto(TrainingDto returnedTrainingDto, TrainingDto trainingDtoToUpdate) {
        if (returnedTrainingDto.getId().equals(trainingDtoToUpdate.getId())) {
            return Mono.just(trainingDtoToUpdate);
        }
        throw new RuntimeException("Training to be Updated & Training from DB are different");
    }

    ////////////////////////////////////////
    // =========== PUBLIC API =========== //
    ////////////////////////////////////////

    public Mono<TrainingDto> findTrainingByIdForPublicAPI(String id) {
        return trainingRepository.findById(id)
                .switchIfEmpty(Mono.error(new TrainingException(String.format("Training with Id:: %s not found ", id),
                        HttpStatus.NOT_FOUND)))
                .map(trainingMapper::toTrainingDtoForPublicAPI);
    }

    public Flux<TrainingDto> findAllTrainingForPublicAPI() {
        return trainingRepository.findAll()
                .map(trainingMapper::toTrainingDtoForPublicAPI);
    }

}
