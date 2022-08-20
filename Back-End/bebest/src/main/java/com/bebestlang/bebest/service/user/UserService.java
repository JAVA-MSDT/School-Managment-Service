package com.bebestlang.bebest.service.user;

import com.bebestlang.bebest.dto.user.UserDto;
import com.bebestlang.bebest.exception.UserException;
import com.bebestlang.bebest.mapper.user.UserMapper;
import com.bebestlang.bebest.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public Mono<UserDto> findUserById(String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new UserException(String.format("User by the id:: %s Not Found", id))))
                .map(userMapper::toUserDto);
    }

    /**
     *
     * @param username to check the user
     * @return true if user exists, false if not exist
     */
    public Mono<Boolean> checkUserAvailabilityByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .flatMap(user ->  user == null ? Mono.just(false) : Mono.just(true));
    }

    public Flux<UserDto> findAllUsers() {
        return userRepository.findAll()
                .map(userMapper::toUserDto);
    }

    public Mono<UserDto> saveUser(UserDto userDto) {
        return userRepository.save(userMapper.toUser(userDto)).map(userMapper::toUserDto);
    }

    public Mono<UserDto> updateUser(UserDto userDto, String userId) {
        return findUserById(userId)
                .flatMap(returnedUserDto -> getValidUserDto(returnedUserDto, userDto))
                .flatMap(this::saveUser);
    }

    private Mono<UserDto> getValidUserDto(UserDto returnedUserDto, UserDto userDtoToUpdate) {
        if(returnedUserDto.getId().equals(userDtoToUpdate.getId())) {
            return Mono.just(userDtoToUpdate);
        }
        throw new RuntimeException("User to be Updated & User from DB are different");
    }
}
