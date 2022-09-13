package com.bebestlang.bebest.service.common;

import java.io.IOException;
import java.util.Base64;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.exception.common.ImageException;
import com.bebestlang.bebest.mapper.common.ImageMapper;
import com.bebestlang.bebest.repository.common.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
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
/*                    File fileImage = new File(imageFile.filename());
                    String imageBase64 = FileUtil.encodeFileToBase64(fileImage);
                    imageDto.setImageBase64(imageBase64);
                    return imageDto;*/
                    return imageFile.content().map(dataBuffer -> {

                                dataBuffer.asByteBuffer();
                                byte[] bytes = new byte[dataBuffer.readableByteCount()];
                                dataBuffer.read(bytes);
                                DataBufferUtils.release(dataBuffer);
                                String imageBase64 = Base64.getEncoder().encodeToString(bytes);
                                System.out.println(imageBase64);
                                //  imageDto.setUrl(Paths.get(uploadDir).resolve(imageFile.filename()).normalize().toString());
                                imageDto.setImageBase64(imageBase64);

                                return imageDto;
                            }).next()
                            .flatMap(imageMap -> imageRepository.save(imageMapper.toImage(imageDto)))
                            .map(imageMapper::toImageDto);
                }).flatMap(imageMap -> imageRepository.save(imageMapper.toImage(imageDto)))
                .map(imageMapper::toImageDto);
    }

/*    public Mono<ImageDto> saveImage(ImageDto imageDto, Mono<FilePart> image) throws IOException {

        return image
                .map(imageFile -> {
                    File fileImage = new File(imageFile.filename());
                    String imageBase64 = FileUtil.encodeFileToBase64(fileImage);
                    imageDto.setImageBase64(imageBase64);
                    return imageDto;
*//*                    return imageFile.content().map(dataBuffer -> {
                                byte[] bytes = new byte[dataBuffer.readableByteCount()];
                                dataBuffer.read(bytes);
                                DataBufferUtils.release(dataBuffer);
                                byte[] imageBytes = dataBuffer.asByteBuffer().array();
                                imageDto.setImage(bytes);
                               //  imageDto.setUrl(Paths.get(uploadDir).resolve(imageFile.filename()).normalize().toString());
                                return imageDto;
                            }).next()
                            .flatMap(imageMap -> imageRepository.save(imageMapper.toImage(imageDto)))
                            .map(imageMapper::toImageDto);*//*
                }).flatMap(imageMap -> imageRepository.save(imageMapper.toImage(imageDto)))
                .map(imageMapper::toImageDto);
    }*/

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
