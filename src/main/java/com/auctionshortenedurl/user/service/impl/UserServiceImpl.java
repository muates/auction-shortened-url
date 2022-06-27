package com.auctionshortenedurl.user.service.impl;

import com.auctionshortenedurl.user.converter.UserRequestConverter;
import com.auctionshortenedurl.user.model.dto.UserDto;
import com.auctionshortenedurl.user.model.entity.UserEntity;
import com.auctionshortenedurl.user.model.request.UserRequest;
import com.auctionshortenedurl.user.repository.UserRepository;
import com.auctionshortenedurl.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRequestConverter userRequestConverter;

    public UserServiceImpl(UserRepository userRepository,
        UserRequestConverter userRequestConverter) {
        this.userRepository = userRepository;
        this.userRequestConverter = userRequestConverter;
    }

    @Override
    public UserDto signUp(UserRequest userRequest) {
        UserEntity userEntity = userRequestConverter.convert(userRequest);
        userRepository.save(userEntity);

        return convertToResponse(userEntity.getUserId());
    }

    private UserDto convertToResponse(Long userId) {
        UserDto user = new UserDto();
        user.setUserId(userId);
        return user;
    }
}
