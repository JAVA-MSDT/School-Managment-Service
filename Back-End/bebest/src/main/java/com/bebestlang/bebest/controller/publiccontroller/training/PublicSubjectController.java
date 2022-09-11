package com.bebestlang.bebest.controller.publiccontroller.training;

import com.bebestlang.bebest.dto.training.SubjectDto;
import com.bebestlang.bebest.service.training.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pu/subjects")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class PublicSubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public Flux<SubjectDto> findAllSubjects() {
        return subjectService.findAllSubjects();
    }

    @GetMapping("/{id}")
    public Mono<SubjectDto> findSubjectById(@PathVariable("id") String id) {
        return subjectService.findSubjectById(id);
    }
}
