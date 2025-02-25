package com.bebestlang.bebest.controller.privatecontroller.training;

import com.bebestlang.bebest.dto.training.SubjectDto;
import com.bebestlang.bebest.mapper.training.SubjectMapper;
import com.bebestlang.bebest.service.training.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pr/subjects")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class SubjectController {

    private final SubjectService subjectService;

    private final SubjectMapper subjectMapper;

    @PostMapping
    public Mono<SubjectDto> saveSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.saveSubject(subjectDto).map(subjectMapper::toSubjectDto);
    }

    @GetMapping
    public Flux<SubjectDto> findAllSubjects() {
        return subjectService.findAllSubjects().map(subjectMapper::toSubjectDto);
    }

    @GetMapping("/{id}")
    public Mono<SubjectDto> findSubjectById(@PathVariable("id") String id) {
        return subjectService.findSubjectById(id).map(subjectMapper::toSubjectDto);
    }
}
