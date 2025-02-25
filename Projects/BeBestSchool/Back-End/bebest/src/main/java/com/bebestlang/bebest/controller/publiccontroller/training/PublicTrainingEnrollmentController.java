package com.bebestlang.bebest.controller.publiccontroller.training;

import com.bebestlang.bebest.dto.training.TrainingEnrollmentDto;
import com.bebestlang.bebest.service.training.TrainingEnrollmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pu/training-enrollments")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class PublicTrainingEnrollmentController {

    private final TrainingEnrollmentService trainingEnrollmentService;

    @GetMapping("/{id}")
    public Mono<TrainingEnrollmentDto> findTrainingById(@PathVariable("id") String id) {
        return trainingEnrollmentService.findTrainingEnrollmentById(id);
    }

    @GetMapping
    public Flux<TrainingEnrollmentDto> findAllTraining() {
        return trainingEnrollmentService.findAllTrainingEnrollment();
    }

    @GetMapping("/training-enrolments/training/{trainingId}")
    public Flux<TrainingEnrollmentDto> findAllTrainingByTrainingId(@PathVariable("trainingId") String trainingId) {
        return trainingEnrollmentService.findAllTrainingByTrainingId(trainingId);
    }

}
