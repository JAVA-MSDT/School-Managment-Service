package com.bebestlang.bebest.controller.privatecontroller.training;

import com.bebestlang.bebest.dto.training.TrainingDto;
import com.bebestlang.bebest.service.training.TrainingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pr/trainings")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping("/{id}")
    public Mono<TrainingDto> findTrainingById(@PathVariable("id") String id) {
        return trainingService.findTrainingById(id);
    }

    @GetMapping
    public Flux<TrainingDto> findAllTraining() {
        return trainingService.findAllTraining();
    }

    @PostMapping
    public Mono<TrainingDto> saveTraining(@RequestBody TrainingDto trainingDto) {
        return trainingService.saveTraining(trainingDto);
    }

    @PutMapping("/{id}")
    public Mono<TrainingDto> updateTraining(@RequestBody TrainingDto trainingDto, @PathVariable("id") String id) {
        return trainingService.updateTraining(trainingDto, id);
    }

}
