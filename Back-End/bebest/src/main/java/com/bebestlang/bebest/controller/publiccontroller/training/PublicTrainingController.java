package com.bebestlang.bebest.controller.publiccontroller.training;

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

@RequestMapping("api/pu/trainings")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class PublicTrainingController {

    private final TrainingService trainingService;

    @GetMapping("/{id}")
    public Mono<TrainingDto> findTrainingByIdForPublicAPI(@PathVariable("id") String id) {
        return trainingService.findTrainingByIdForPublicAPI(id);
    }

    @GetMapping
    public Flux<TrainingDto> findAllTrainingForPublicAPI() {
        return trainingService.findAllTrainingForPublicAPI();
    }

}
