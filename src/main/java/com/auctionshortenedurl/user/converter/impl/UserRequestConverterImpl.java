package com.auctionshortenedurl.user.converter.impl;

import com.auctionshortenedurl.user.converter.UserRequestConverter;
import com.auctionshortenedurl.user.model.entity.UserEntity;
import com.auctionshortenedurl.user.model.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserRequestConverterImpl implements UserRequestConverter {

    @Override
    public UserEntity convert(UserRequest source) {
        if (source == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(source.getUsername());
        userEntity.setPassword(source.getPassword());

        return userEntity;
    }
}
