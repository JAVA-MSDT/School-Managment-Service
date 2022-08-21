package com.bebestlang.bebest.repository.training;

import com.bebestlang.bebest.modal.training.Training;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TrainingRepository extends ReactiveMongoRepository<Training, String> {

}
