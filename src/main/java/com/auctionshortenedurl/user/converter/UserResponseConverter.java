package com.auctionshortenedurl.user.converter;

import com.auctionshortenedurl.user.model.dto.UserDto;
import com.auctionshortenedurl.user.model.entity.UserEntity;

public interface UserResponseConverter {
    UserDto convert(UserEntity userEntity);
}
