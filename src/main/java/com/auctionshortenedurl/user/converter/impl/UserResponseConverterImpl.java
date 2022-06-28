package com.auctionshortenedurl.user.converter.impl;

import com.auctionshortenedurl.user.converter.UserResponseConverter;
import com.auctionshortenedurl.user.model.dto.UserDto;
import com.auctionshortenedurl.user.model.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserResponseConverterImpl implements UserResponseConverter {

    @Override
    public UserDto convert(UserEntity source) {
        if (source == null) {
            return null;
        }

        UserDto user = new UserDto();
        user.setUserId(source.getUserId());

        return user;
    }

}
