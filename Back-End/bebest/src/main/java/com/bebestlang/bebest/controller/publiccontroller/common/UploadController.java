package com.bebestlang.bebest.controller.publiccontroller.common;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/pu/upload")
@RequiredArgsConstructor
public class UploadController {

    private final Path basePath = Paths.get("./src/main/resources/files/");

    @PostMapping("file/single")
    public Mono<Void> upload(@RequestPart("user-name") String name,
            @RequestPart("fileToUpload") Mono<FilePart> filePartMono){
        System.out.println("user : " + name);
        return  filePartMono
                .doOnNext(fp -> System.out.println("Received File : " + fp.filename()))
                .flatMap(fp -> fp.transferTo(basePath.resolve(fp.filename())))
                .then();
    }

    @PostMapping("file/multi1")
    public Mono<Void> upload(@RequestPart("files") Flux<FilePart> partFlux){
        return  partFlux
                .doOnNext(fp -> System.out.println(fp.filename()))
                .flatMap(fp -> fp.transferTo(basePath.resolve(fp.filename())))
                .then();
    }

    private final ReactiveGridFsTemplate gridFsTemplate;

    @PostMapping("")
    public Mono<ResponseEntity> upload(@RequestPart Mono<FilePart> fileParts) {
        return fileParts
                .flatMap(part -> this.gridFsTemplate.store(part.content(), part.filename()))
                .map((id) -> ok().body(Map.of("id", id.toHexString())));
    }

    @GetMapping("{id}")
    public Flux<Void> read(@PathVariable String id, ServerWebExchange exchange) {
        return this.gridFsTemplate.findOne(query(where("_id").is(id)))
                .log()
                .flatMap(gridFsTemplate::getResource)
                .flatMapMany(r -> exchange.getResponse().writeWith(r.getDownloadStream()));
    }

}
