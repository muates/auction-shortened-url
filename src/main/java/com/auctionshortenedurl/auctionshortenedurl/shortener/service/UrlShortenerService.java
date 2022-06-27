package com.auctionshortenedurl.auctionshortenedurl.shortener.service;

import com.auctionshortenedurl.auctionshortenedurl.shortener.model.entity.UrlEntity;
import com.auctionshortenedurl.auctionshortenedurl.shortener.model.request.UrlLongRequest;
import com.auctionshortenedurl.auctionshortenedurl.shortener.model.request.UrlShortenerRequest;
import java.util.List;

public interface UrlShortenerService {

    UrlEntity createShortUrl(Long userId, UrlShortenerRequest request);

    UrlEntity getLongUrlByShortUrl(UrlLongRequest request);

    List<UrlEntity> getAllUrl(Long userId);

    UrlEntity getUrl(Long userId, Long urlId);

    void deleteUrl(Long userId, Long urlId);
}
