package com.bebestlang.bebest.repository.user;

import com.bebestlang.bebest.modal.user.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
