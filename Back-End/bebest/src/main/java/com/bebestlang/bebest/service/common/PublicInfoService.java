package com.bebestlang.bebest.service.common;

import com.bebestlang.bebest.dto.common.PublicInfoDto;
import com.bebestlang.bebest.exception.common.PublicInfoException;
import com.bebestlang.bebest.mapper.common.PublicInfoMapper;
import com.bebestlang.bebest.repository.common.PublicInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublicInfoService {

    private final PublicInfoRepository publicInfoRepository;

    private final PublicInfoMapper publicInfoMapper;

    public Mono<PublicInfoDto> savePublicInfo(PublicInfoDto publicInfoDto) {
        return publicInfoRepository.save(publicInfoMapper.toPublicInfo(publicInfoDto))
                .map(publicInfoMapper::toPublicInfoDto);
    }

    public Flux<PublicInfoDto> findAllPublicInfo() {
        return publicInfoRepository.findAll()
                .map(publicInfoMapper::toPublicInfoDto);
    }

    public Mono<PublicInfoDto> findPublicInfoById(String id) {
        return publicInfoRepository.findById(id)
                .switchIfEmpty(
                        Mono.error(new PublicInfoException(String.format("Public Info with Id:: %s not found ", id),
                                HttpStatus.NOT_FOUND)))
                .map(publicInfoMapper::toPublicInfoDto);
    }

}
