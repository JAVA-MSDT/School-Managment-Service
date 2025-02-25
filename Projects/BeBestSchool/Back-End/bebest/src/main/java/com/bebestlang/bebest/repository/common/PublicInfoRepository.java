package com.bebestlang.bebest.repository.common;

import com.bebestlang.bebest.modal.common.PublicInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PublicInfoRepository extends ReactiveMongoRepository<PublicInfo, String> {

}
