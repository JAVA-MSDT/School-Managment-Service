package com.bebestlang.bebest.controller;

import com.bebestlang.bebest.dto.subject.SubjectDto;
import com.bebestlang.bebest.service.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/subjects")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public Mono<SubjectDto> saveSubject(SubjectDto subjectDto) {
        return subjectService.saveSubject(subjectDto);
    }

    @GetMapping
    public Flux<SubjectDto> findAllSubjects() {
        return subjectService.findAllSubjects();
    }

    @GetMapping("/{id}")
    public Mono<SubjectDto> findSubjectById(@PathVariable("id") String id) {
        return subjectService.findSubjectById(id);
    }
}
