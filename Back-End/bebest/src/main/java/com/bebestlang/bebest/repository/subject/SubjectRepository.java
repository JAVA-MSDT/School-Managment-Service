package com.bebestlang.bebest.repository.subject;

import com.bebestlang.bebest.modal.subject.Subject;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SubjectRepository extends ReactiveMongoRepository<Subject, String> {

}
