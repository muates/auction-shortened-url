package com.auctionshortenedurl.auctionshortenedurl.user.converter;

import com.auctionshortenedurl.auctionshortenedurl.user.model.entity.UserEntity;
import com.auctionshortenedurl.auctionshortenedurl.user.model.request.UserRequest;

public interface UserRequestConverter {
    UserEntity convert(UserRequest userRequest);
}
