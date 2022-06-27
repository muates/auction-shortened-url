package com.auctionshortenedurl.user.converter;

import com.auctionshortenedurl.user.model.entity.UserEntity;
import com.auctionshortenedurl.user.model.request.UserRequest;

public interface UserRequestConverter {
    UserEntity convert(UserRequest userRequest);
}
