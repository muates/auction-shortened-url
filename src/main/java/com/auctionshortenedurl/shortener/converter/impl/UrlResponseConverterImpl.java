package com.auctionshortenedurl.shortener.converter.impl;

import com.auctionshortenedurl.shortener.converter.UrlResponseConverter;
import com.auctionshortenedurl.shortener.model.dto.UrlDto;
import com.auctionshortenedurl.shortener.model.entity.UrlEntity;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class UrlResponseConverterImpl implements UrlResponseConverter {

    @Override
    public UrlDto convert(UrlEntity source) {
        if (source == null) {
            return null;
        }

        UrlDto url = new UrlDto();
        url.setLongUrl(source.getLongUrl());
        url.setShortUrl(source.getShortUrl());
        url.setId(source.getId());

        return url;
    }

    @Override
    public List<UrlDto> convert(Long userId, List<UrlEntity> urlEntityList) {
        if (CollectionUtils.isEmpty(urlEntityList))
        {
            return Collections.emptyList();
        }

        return urlEntityList
            .stream()
            .filter(urlEntity -> urlEntity.getUserId().equals(userId))
            .map(convertToUrl()).collect(Collectors.toList());
    }

    private Function<UrlEntity, UrlDto> convertToUrl() {
        return urlEntity -> {
            UrlDto url = new UrlDto();
            url.setId(urlEntity.getId());
            url.setLongUrl(urlEntity.getLongUrl());
            url.setShortUrl(urlEntity.getShortUrl());
            return url;
        };
    }
}
