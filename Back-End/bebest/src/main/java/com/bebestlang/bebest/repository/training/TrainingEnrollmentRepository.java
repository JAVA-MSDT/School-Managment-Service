package com.bebestlang.bebest.repository.training;

import com.bebestlang.bebest.modal.training.TrainingEnrollment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TrainingEnrollmentRepository extends ReactiveMongoRepository<TrainingEnrollment, String> {

}
