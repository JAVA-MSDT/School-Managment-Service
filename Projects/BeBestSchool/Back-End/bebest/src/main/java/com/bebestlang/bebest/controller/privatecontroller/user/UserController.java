package com.bebestlang.bebest.controller.privatecontroller.user;

import com.bebestlang.bebest.dto.user.UserDto;
import com.bebestlang.bebest.modal.user.User;
import com.bebestlang.bebest.repository.user.UserRepository;
import com.bebestlang.bebest.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/pr/users")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public Mono<UserDto> findUserById(@PathVariable("id") String id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public Flux<User> findAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public Mono<UserDto> saveUser(@RequestBody UserDto userDto) {
        log.info("User Dto Save" + userDto);
        return userService.saveUser(userDto);
    }

    @PutMapping("/{id}")
    public Mono<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") String userId) {
        return userService.updateUser(userDto, userId);
    }

    @GetMapping("/user-availability/{username}")
    public Mono<Boolean> checkUserAvailabilityByUsername(@PathVariable("username") String username) {
        return userService.checkUserAvailabilityByUsername(username);
    }

}
