package com.bebestlang.bebest.service.training;

import com.bebestlang.bebest.dto.training.TrainingEnrollmentDto;
import com.bebestlang.bebest.exception.training.TrainingEnrollmentException;
import com.bebestlang.bebest.mapper.training.TrainingEnrollmentMapper;
import com.bebestlang.bebest.repository.training.TrainingEnrollmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainingEnrollmentService {

    private final TrainingEnrollmentRepository trainingEnrollmentRepository;

    private final TrainingEnrollmentMapper trainingEnrollmentMapper;

    public Mono<TrainingEnrollmentDto> findTrainingEnrollmentById(String id) {
        return trainingEnrollmentRepository.findById(id)
                .switchIfEmpty(Mono.error(new TrainingEnrollmentException(
                        String.format("Training Enrollment with Id:: %s not found ", id), HttpStatus.NOT_FOUND)))
                .map(trainingEnrollmentMapper::toTrainingEnrollmentDto);
    }

    public Flux<TrainingEnrollmentDto> findAllTrainingByTrainingId(String trainingId) {
        return trainingEnrollmentRepository.findAllByTrainingId(trainingId)
                .switchIfEmpty(Mono.error(new TrainingEnrollmentException(
                        String.format("Training Enrollments with Training Id:: %s not found ", trainingId),
                        HttpStatus.NOT_FOUND)))
                .map(trainingEnrollmentMapper::toTrainingEnrollmentDto);
    }

    public Flux<TrainingEnrollmentDto> findAllTrainingEnrollment() {
        return trainingEnrollmentRepository.findAll()
                .map(trainingEnrollmentMapper::toTrainingEnrollmentDto);
    }

    public Mono<TrainingEnrollmentDto> saveTrainingEnrollment(TrainingEnrollmentDto trainingDto) {
        return trainingEnrollmentRepository.save(trainingEnrollmentMapper.toTrainingEnrollment(trainingDto))
                .map(trainingEnrollmentMapper::toTrainingEnrollmentDto);
    }

    public Mono<TrainingEnrollmentDto> updateTrainingEnrollment(TrainingEnrollmentDto trainingDto, String id) {
        return findTrainingEnrollmentById(id)
                .flatMap(returnedTrainingEnrollmentDto -> getValidTrainingEnrollmentDto(returnedTrainingEnrollmentDto,
                        trainingDto))
                .flatMap(this::saveTrainingEnrollment);
    }

    private Mono<TrainingEnrollmentDto> getValidTrainingEnrollmentDto(
            TrainingEnrollmentDto returnedTrainingEnrollmentDto, TrainingEnrollmentDto trainingDtoToUpdate) {
        if (returnedTrainingEnrollmentDto.getId().equals(trainingDtoToUpdate.getId())) {
            return Mono.just(trainingDtoToUpdate);
        }
        throw new RuntimeException("Training Enrollment to be Updated & Training Enrollment from DB are different");
    }

}
