package com.auctionshortenedurl.auctionshortenedurl.shortener.converter;

import com.auctionshortenedurl.auctionshortenedurl.shortener.model.entity.UrlEntity;
import com.auctionshortenedurl.auctionshortenedurl.shortener.model.request.UrlShortenerRequest;

public interface UrlRequestConverter {
    UrlEntity convert(Long userId, String shortUrl, UrlShortenerRequest request);
}
