package com.auctionshortenedurl.user.controller;

import com.auctionshortenedurl.user.converter.UserResponseConverter;
import com.auctionshortenedurl.user.model.dto.UserDto;
import com.auctionshortenedurl.user.model.request.UserRequest;
import com.auctionshortenedurl.user.service.UserService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.auctionshortenedurl.user.controller.endpoint.UserControllerEndpoint.*;

@RestController
public class UserController {

    private final UserService userService;
    private final UserResponseConverter userResponseConverter;

    public UserController(UserService userService,
        UserResponseConverter userResponseConverter) {
        this.userService = userService;
        this.userResponseConverter = userResponseConverter;
    }

    @PostMapping(value = REGISTER)
    public UserDto signUp(@RequestBody @Valid UserRequest request) {
        return userResponseConverter.convert(userService.signUp(request));
    }

}
