package com.bebestlang.bebest.repository.user;

import com.bebestlang.bebest.modal.user.Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AddressRepository extends ReactiveMongoRepository<Address, String> {

}
