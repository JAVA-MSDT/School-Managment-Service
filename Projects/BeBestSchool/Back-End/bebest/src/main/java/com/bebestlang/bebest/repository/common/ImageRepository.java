package com.bebestlang.bebest.repository.common;

import com.bebestlang.bebest.modal.common.Image;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ImageRepository extends ReactiveMongoRepository<Image, String> {

     Flux<Image> findAllByPlacesOfUsedAndPurposeOfUses(int placeOfUsed, String purposeOfUses);
}
