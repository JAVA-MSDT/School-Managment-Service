package com.bebestlang.bebest.controller.publiccontroller.common;

import com.bebestlang.bebest.dto.common.PublicInfoDto;
import com.bebestlang.bebest.dto.training.SubjectDto;
import com.bebestlang.bebest.exception.common.PublicInfoException;
import com.bebestlang.bebest.service.common.PublicInfoService;
import com.bebestlang.bebest.service.training.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pu/public-info")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class PublicInfoPublicController {

    private final PublicInfoService publicInfoService;

    @PostMapping
    public Mono<PublicInfoDto> savePublicInfo(@RequestBody PublicInfoDto publicInfoDto) {
        return publicInfoService.savePublicInfo(publicInfoDto);
    }

    @GetMapping
    public Flux<PublicInfoDto> findPublicInfoById() {
        return publicInfoService.findAllPublicInfo();
    }

    @GetMapping("/{id}")
    public Mono<PublicInfoDto> findPublicInfoById(@PathVariable("id")  String id) {
        return publicInfoService.findPublicInfoById(id);
    }
}
