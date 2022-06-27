package com.auctionshortenedurl.shortener.repository;

import com.auctionshortenedurl.shortener.model.entity.UrlEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortenerRepository extends JpaRepository<UrlEntity, Long> {

    Optional<UrlEntity> findByShortUrl(String shortUrl);

    List<UrlEntity> findAllByUserId(Long userId);

}
