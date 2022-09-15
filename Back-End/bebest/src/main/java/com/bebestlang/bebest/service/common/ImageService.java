package com.bebestlang.bebest.service.common;

import java.io.IOException;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.exception.common.ImageException;
import com.bebestlang.bebest.mapper.common.ImageMapper;
import com.bebestlang.bebest.repository.common.ImageRepository;
import com.bebestlang.bebest.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {

    @Value("${images.upload-dir}")
    private String uploadDir;

    private final ImageRepository imageRepository;

    private final ImageMapper imageMapper;

    public Mono<ImageDto> saveImage(ImageDto imageDto, Mono<FilePart> image) throws IOException {

        return image
                .flatMap(imageFile -> {
                    return imageFile.content().map(dataBuffer -> {
                        setImageBase64(imageDto, dataBuffer);
                        setImageExtension(imageDto, imageFile.filename());
                        return imageDto;
                    }).next();
                }).flatMap(imageMap -> imageRepository.save(imageMapper.toImage(imageDto)))
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

    private void setImageBase64(ImageDto imageDto, DataBuffer dataBuffer) {
        String imageBase64 = FileUtil.encodeDataBufferToBase64(dataBuffer);
        imageDto.setImageBase64(imageBase64);
    }

    private void setImageExtension(ImageDto imageDto, String imageName) {
        String imageExtension = StringUtils.getFilenameExtension(imageName);
        imageDto.setExtension(imageExtension);
    }

}
