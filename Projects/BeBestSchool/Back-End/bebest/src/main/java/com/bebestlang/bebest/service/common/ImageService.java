package com.bebestlang.bebest.service.common;

import java.io.IOException;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.exception.common.ImageException;
import com.bebestlang.bebest.mapper.common.ImageMapper;
import com.bebestlang.bebest.modal.common.Image;
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

    public Mono<Image> saveImage(ImageDto imageDto, Mono<FilePart> image) {

        return image
                .flatMap(imageFile -> {
                    return imageFile.content().map(dataBuffer -> {
                        setImageBase64(imageDto, dataBuffer);
                        setImageExtension(imageDto, imageFile.filename());
                        return imageDto;
                    }).next();
                }).flatMap(imageMap -> imageRepository.save(imageMapper.toImage(imageDto)));
    }

    public Mono<Image> findImageById(String id) {
        return imageRepository.findById(id)
                .switchIfEmpty(Mono.error(new ImageException(String.format("Image with Id:: %s not found ", id),
                        HttpStatus.NOT_FOUND)));
    }

    public Flux<Image> findAllImages() {
        return imageRepository.findAll();
    }

    public Flux<Image> findAllByPlacesOfUsedAndPurposeOfUses(int placeOfUsed, String purposeOfUses) {
        return imageRepository.findAllByPlacesOfUsedAndPurposeOfUses(placeOfUsed, purposeOfUses)
                .switchIfEmpty(Mono.error(new ImageException(String.format("No Images matching the search criteria :: %s & %s ", placeOfUsed, purposeOfUses),
                        HttpStatus.NOT_FOUND)));
    }

    public Mono<Void> deleteImageById(String id) {
        return this.findImageById(id).flatMap(imageRepository::delete);
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
