package com.auctionshortenedurl.shortener.converter.impl;

import com.auctionshortenedurl.shortener.converter.UrlRequestConverter;
import com.auctionshortenedurl.shortener.model.entity.UrlEntity;
import com.auctionshortenedurl.shortener.model.request.UrlShortenerRequest;
import org.springframework.stereotype.Component;

@Component
public class UrlRequestImpl implements UrlRequestConverter {

    @Override
    public UrlEntity convert(Long userId, String shortUrl, UrlShortenerRequest source) {
        if (source == null) {
            return null;
        }

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setLongUrl(source.getLongUrl());
        urlEntity.setShortUrl(shortUrl);
        urlEntity.setUserId(userId);
        return urlEntity;
    }
}
