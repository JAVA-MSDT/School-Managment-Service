package com.bebestlang.bebest.service.training;

import com.bebestlang.bebest.dto.training.SubjectDto;
import com.bebestlang.bebest.exception.training.SubjectException;
import com.bebestlang.bebest.mapper.training.SubjectMapper;
import com.bebestlang.bebest.modal.training.Subject;
import com.bebestlang.bebest.repository.training.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public Mono<Subject> saveSubject(SubjectDto subjectDto) {
        return subjectRepository.save(subjectMapper.toSubject(subjectDto));
    }

    public Flux<Subject> findAllSubjects() {
        return subjectRepository.findAll();

    }

    public Mono<Subject> findSubjectById(String id) {
        return subjectRepository.findById(id)
                .switchIfEmpty(Mono.error(new SubjectException(String.format("Subject with Id:: %s not found ", id),
                        HttpStatus.NOT_FOUND)));

    }

}
