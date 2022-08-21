package com.bebestlang.bebest.repository.training;

import com.bebestlang.bebest.modal.training.TrainingEnrollment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TrainingEnrollmentRepository extends ReactiveMongoRepository<TrainingEnrollment, String> {

    Flux<TrainingEnrollment> findAllByTrainingId(String trainingId);
}
