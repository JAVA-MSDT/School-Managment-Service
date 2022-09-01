package com.bebestlang.bebest.service.common;

import java.io.IOException;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.exception.common.ImageException;
import com.bebestlang.bebest.mapper.common.ImageMapper;
import com.bebestlang.bebest.repository.common.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    private final ImageMapper imageMapper;

    public Mono<ImageDto> saveImage(ImageDto imageDto, Mono<FilePart> image) throws IOException {

        return image.flatMap(imageFile -> imageFile.content().map(dataBuffer -> {
                            byte[] imageBytes = new byte[dataBuffer.readableByteCount()];
                            imageDto.setImage(imageBytes);
                            return imageBytes;
                        })
                        .singleOrEmpty())
                .doOnNext(System.out::println)
                .flatMap(imageMap -> imageRepository.save(imageMapper.toImage(imageDto)))
                .doOnNext(System.out::println)
                .map(imageMapper::toImageDto);
    }

    public Mono<ImageDto> findImageById(String id) {
        return imageRepository.findById(id)
                .switchIfEmpty(Mono.error(new ImageException(String.format("Image with Id:: %s not found ", id),
                        HttpStatus.NOT_FOUND)))
                .map(imageMapper::toImageDto);
    }

    public Flux<ImageDto> findAllImages() {
        return imageRepository.findAll()
                .map(imageMapper::toImageDto);
    }

}
