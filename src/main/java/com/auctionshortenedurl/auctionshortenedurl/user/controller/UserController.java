package com.auctionshortenedurl.auctionshortenedurl.user.controller;

import com.auctionshortenedurl.auctionshortenedurl.user.model.dto.UserDto;
import com.auctionshortenedurl.auctionshortenedurl.user.model.request.UserRequest;
import com.auctionshortenedurl.auctionshortenedurl.user.service.UserService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.auctionshortenedurl.auctionshortenedurl.user.controller.endpoint.UserControllerEndpoint.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = REGISTER)
    public UserDto signUp(@RequestBody @Valid UserRequest request) {
        return userService.signUp(request);
    }

}
