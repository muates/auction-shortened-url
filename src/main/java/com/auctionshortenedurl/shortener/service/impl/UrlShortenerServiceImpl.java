package com.auctionshortenedurl.shortener.service.impl;

import com.auctionshortenedurl.exception.EntityExistsException;
import com.auctionshortenedurl.exception.NotFoundException;
import com.auctionshortenedurl.shortener.converter.UrlRequestConverter;
import com.auctionshortenedurl.shortener.model.entity.UrlEntity;
import com.auctionshortenedurl.shortener.model.request.UrlLongRequest;
import com.auctionshortenedurl.shortener.model.request.UrlShortenerRequest;
import com.auctionshortenedurl.shortener.repository.UrlShortenerRepository;
import com.auctionshortenedurl.shortener.service.UrlShortenerService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Transactional
public class UrlShortenerServiceImpl implements UrlShortenerService {

    public static final String SHORT_URL_BASE = "http://localhost:8080/";

    private final UrlShortenerRepository urlShortenerRepository;
    private final UrlRequestConverter urlRequestConverter;

    public UrlShortenerServiceImpl(
        UrlShortenerRepository urlShortenerRepository,
        UrlRequestConverter urlRequestConverter) {
        this.urlShortenerRepository = urlShortenerRepository;
        this.urlRequestConverter = urlRequestConverter;
    }

    @Override
    public UrlEntity createShortUrl(Long userId, UrlShortenerRequest request) {
        List<UrlEntity> urlEntityList = urlShortenerRepository.findAllByUserId(userId);

        if (!CollectionUtils.isEmpty(urlEntityList)) {
            urlEntityList.forEach(urlEntity -> {
                if (Objects.equals(urlEntity.getLongUrl(), request.getLongUrl())) {
                    throw new EntityExistsException("Url already exist: " + request.getLongUrl());
                }
            });
        }

        String shortUrl = createShortenerUrl(userId, request.getLongUrl());
        UrlEntity urlEntity = urlRequestConverter.convert(userId, shortUrl, request);
        return urlShortenerRepository.save(urlEntity);
    }

    @Override
    public UrlEntity getLongUrlByShortUrl(UrlLongRequest request) {
        Optional<UrlEntity> optUrlEntity = urlShortenerRepository.findByShortUrl(request.getShortUrl());

        if (optUrlEntity.isEmpty()) {
            throw new NotFoundException("Url not found with shortUrl: " + request.getShortUrl());
        }

        return optUrlEntity.get();
    }

    @Override
    public List<UrlEntity> getAllUrl(Long userId) {
        List<UrlEntity> urlEntityList = urlShortenerRepository.findAllByUserId(userId);

        if (CollectionUtils.isEmpty(urlEntityList)) {
            throw new NotFoundException("Urls not found with id: " + userId);
        }

        return urlEntityList;
    }

    @Override
    public UrlEntity getUrl(Long userId, Long urlId) {
        Optional<UrlEntity> optUrlEntity = urlShortenerRepository.findById(urlId);

        if (optUrlEntity.isEmpty()
            || !Objects.equals(optUrlEntity.get().getUserId(), userId)) {
            throw new NotFoundException("Url not found with id: " + urlId);
        }

        return optUrlEntity.get();
    }

    @Override
    public void deleteUrl(Long userId, Long urlId) {
        UrlEntity urlEntity = getUrl(userId, urlId);
        urlShortenerRepository.delete(urlEntity);
    }

    private String createShortenerUrl(Long userId, String longUrl) {
        return SHORT_URL_BASE + longUrl.hashCode() + userId;
    }

}
