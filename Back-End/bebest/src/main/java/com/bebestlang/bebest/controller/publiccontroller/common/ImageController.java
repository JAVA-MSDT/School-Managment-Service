package com.bebestlang.bebest.controller.publiccontroller.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

import com.bebestlang.bebest.dto.common.ImageDto;
import com.bebestlang.bebest.modal.common.FileStatus;
import com.bebestlang.bebest.modal.common.PurposeOfUse;
import com.bebestlang.bebest.service.common.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pu/images")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class ImageController {

    @Value("${images.upload-dir}")
    private String uploadDir;

    private final Path basePath = Paths.get("./src/main/resources/files/");

    private final ImageService imageService;

    private final ReactiveGridFsTemplate gridFsTemplate;

    @PostMapping()
    public Mono<ImageDto> saveImage(@RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "englishAlt", required = false) String englishAlt,
            @RequestParam(value = "polishAlt", required = false) String polishAlt,
            @RequestParam(value = "fileStatus", required = false) FileStatus fileStatus,
            @RequestParam(value = "purposeOfUses", required = false) Set<PurposeOfUse> purposeOfUses,
            @RequestParam(value = "placesOfUsed", required = false) Set<Integer> placesOfUsed,
            @RequestPart("image") Mono<FilePart> image) throws IOException {

        ImageDto imageDto = ImageDto.builder()
                .id(id)
                .title(title)
                .alt(buildTranslationMap(englishAlt, polishAlt))
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

    @PostMapping(value = "/byte")
    public Mono<Void> getBytes(@RequestPart("image") Mono<FilePart> imageFile) throws IOException {
        return imageFile.flatMap(image -> image.transferTo(basePath.resolve(image.filename()))
        ).then();
    }

    private byte[] convertFilePartToByteArray(FilePart file) throws IOException {
        File convFile = new File(file.filename());
        System.out.println("convFile.isFile(): " + convFile.isFile());
        System.out.println("convFile.getName(): " + convFile.getName());
        System.out.println("convFile.getPath(): " + convFile.getPath());
        System.out.println("convFile.getAbsolutePath(): " + convFile.getAbsolutePath());
        file.transferTo(convFile);
        return Files.readAllBytes(convFile.toPath());
      /*  return DataBufferUtils.join(file.content())
                .map(dataBuffer -> dataBuffer.asByteBuffer().array());*/
    }

    private Map<String, String> buildTranslationMap(String english, String polish) {
        return Map.of("EN", english, "PL", polish);
    }
}
