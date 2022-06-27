package com.auctionshortenedurl.user.repository;

import com.auctionshortenedurl.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
