package com.bebestlang.bebest.controller.publiccontroller.common;

import java.io.IOException;
import java.util.Set;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.exception.common.ImageException;
import com.bebestlang.bebest.modal.common.FileStatus;
import com.bebestlang.bebest.modal.common.PurposeOfUse;
import com.bebestlang.bebest.service.common.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pu/images")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageService imageService;

    @PostMapping()
    public Mono<ImageDto> saveImage(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "alt", required = false) String alt, @RequestParam(value = "fileStatus", required = false) FileStatus fileStatus,
            @RequestParam(value = "purposeOfUses", required = false) Set<PurposeOfUse> purposeOfUses, @RequestParam(value = "placesOfUsed", required = false) Set<Integer> placesOfUsed,
            @RequestPart("image") Mono<FilePart> image) throws IOException {


        ImageDto imageDto = ImageDto.builder()
                .id(id)
                .title(title)
                .alt(alt)
                .fileStatus(fileStatus)
                .purposeOfUses(purposeOfUses)
                .placesOfUsed(placesOfUsed)
                .build();
        return imageService.saveImage(imageDto, image);
    }

    @GetMapping(value = "/{id}")
    public Mono<ImageDto> findImageById(@PathVariable("id") String id) {
        return imageService.findImageById(id);
    }

    @GetMapping
    public Flux<ImageDto> findAllImages() {
        return imageService.findAllImages();
    }


}
