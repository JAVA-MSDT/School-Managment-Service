package com.bebestlang.bebest.controller.publiccontroller.common;

import java.io.IOException;
import java.util.Set;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.mapper.common.ImageMapper;
import com.bebestlang.bebest.modal.common.FileStatus;
import com.bebestlang.bebest.modal.common.Image;
import com.bebestlang.bebest.modal.common.PurposeOfUse;
import com.bebestlang.bebest.service.common.ImageService;
import com.bebestlang.bebest.util.CommonUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pu/images")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageService imageService;

    private final ImageMapper imageMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ImageDto> saveImage(@RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "englishAlt", required = false) String englishAlt,
            @RequestParam(value = "polishAlt", required = false) String polishAlt,
            @RequestParam(value = "englishDescription", required = false) String englishDescription,
            @RequestParam(value = "polishDescription", required = false) String polishDescription,
            @RequestParam(value = "fileStatus", required = false) FileStatus fileStatus,
            @RequestParam(value = "purposeOfUses", required = false) Set<PurposeOfUse> purposeOfUses,
            @RequestParam(value = "placesOfUsed", required = false) Set<Integer> placesOfUsed,
            @RequestPart("image") Mono<FilePart> image) throws IOException {

        ImageDto imageDto = ImageDto.builder()
                .id(id)
                .title(title)
                .alt(CommonUtility.buildTranslationMap(englishAlt, polishAlt))
                .description(CommonUtility.buildTranslationMap(englishDescription, polishDescription))
                .fileStatus(fileStatus)
                .purposeOfUses(purposeOfUses)
                .placesOfUsed(placesOfUsed)
                .build();
        return imageService.saveImage(imageDto, image)
                .map(imageMapper::toImageDto);
    }

    @GetMapping(value = "/{id}")
    public Mono<ImageDto> findImageById(@PathVariable("id") String id) {
        return imageService.findImageById(id)
                .map(imageMapper::toImageDto);
    }

    @GetMapping
    public Flux<ImageDto> findAllImages() {
        return imageService.findAllImages()
                .map(imageMapper::toImageDto);
    }

    @GetMapping("/place-purpose")
    public Flux<ImageDto> findAllByPlacesOfUsedAndPurposeOfUses(@RequestParam("placeOfUsed") int placeOfUsed, @RequestParam("purposeOfUses") String purposeOfUses) {
        return imageService.findAllByPlacesOfUsedAndPurposeOfUses(placeOfUsed, purposeOfUses)
                .map(imageMapper::toImageDto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteImageById(@PathVariable("id") String id) {
        return imageService.deleteImageById(id);
    }
}
