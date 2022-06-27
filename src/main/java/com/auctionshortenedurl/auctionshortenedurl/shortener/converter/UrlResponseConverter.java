package com.auctionshortenedurl.auctionshortenedurl.shortener.converter;

import com.auctionshortenedurl.auctionshortenedurl.shortener.model.dto.UrlDto;
import com.auctionshortenedurl.auctionshortenedurl.shortener.model.entity.UrlEntity;
import java.util.List;

public interface UrlResponseConverter {
    UrlDto convert(UrlEntity urlEntity);
    List<UrlDto> convert(Long userId, List<UrlEntity> urlEntityList);
}
