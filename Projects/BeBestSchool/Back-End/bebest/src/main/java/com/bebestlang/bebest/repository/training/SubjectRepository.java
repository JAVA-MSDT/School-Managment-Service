package com.bebestlang.bebest.repository.training;

import com.bebestlang.bebest.modal.training.Subject;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SubjectRepository extends ReactiveMongoRepository<Subject, String> {

}
