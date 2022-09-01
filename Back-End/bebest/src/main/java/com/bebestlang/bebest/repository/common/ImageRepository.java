package com.bebestlang.bebest.repository.common;

import com.bebestlang.bebest.modal.common.Image;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ImageRepository extends ReactiveMongoRepository<Image, String> {

}
