package com.bebestlang.bebest.controller.publiccontroller.user;

import com.bebestlang.bebest.dto.user.UserDto;
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

@RequestMapping("api/pu/users")
@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin(origins = "*")
public class PublicUserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Mono<UserDto> findUserByIdForPublicAPI(@PathVariable("id") String id) {
        return userService.findUserByIdForPublicAPI(id);
    }

    @GetMapping
    public Flux<UserDto> findAllUsersForPublicAPI() {
        return userService.findAllUsersForPublicAPI();
    }

    @GetMapping("/user-availability/{username}")
    public Mono<Boolean> checkUserAvailabilityByUsername(@PathVariable("username") String username) {
        return userService.checkUserAvailabilityByUsername(username);
    }

    @GetMapping("/teachers")
    public Flux<UserDto> findAllUsersForPublicAPIWithTeacherRole() {
        return userService.findAllUsersForPublicAPIWithTeacherRole();
    }

}
