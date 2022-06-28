package com.auctionshortenedurl.shortener.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.auctionshortenedurl.shortener.converter.UrlRequestConverter;
import com.auctionshortenedurl.shortener.model.entity.UrlEntity;
import com.auctionshortenedurl.shortener.model.request.UrlLongRequest;
import com.auctionshortenedurl.shortener.model.request.UrlShortenerRequest;
import com.auctionshortenedurl.shortener.repository.UrlShortenerRepository;
import com.auctionshortenedurl.shortener.service.impl.UrlShortenerServiceImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

public class UrlShortenerServiceTest {

    private static final String LONG_URL = "https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular";
    private static final String SHORT_URL = "http://localhost:8080/6133397771000";
    private static final Long USER_ID = 1000L;

    @InjectMocks
    private UrlShortenerServiceImpl urlShortenerService;

    @Mock
    private UrlShortenerRepository urlShortenerRepository;

    @Mock
    private UrlRequestConverter urlRequestConverter;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCrateShortUrl() {
        UrlShortenerRequest request = new UrlShortenerRequest();
        request.setLongUrl(LONG_URL);

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setLongUrl(request.getLongUrl());
        urlEntity.setShortUrl(SHORT_URL);
        urlEntity.setUserId(USER_ID);

        UrlEntity savedUrlEntity = new UrlEntity();
        savedUrlEntity.setShortUrl(SHORT_URL);
        savedUrlEntity.setLongUrl(LONG_URL);
        savedUrlEntity.setUserId(USER_ID);
        savedUrlEntity.setId(1L);

        when(urlShortenerRepository.findAllByUserId(USER_ID)).thenReturn(Collections.emptyList());
        when(urlRequestConverter.convert(USER_ID, SHORT_URL, request)).thenReturn(urlEntity);
        when(urlShortenerRepository.save(urlEntity)).thenReturn(savedUrlEntity);

        UrlEntity response = urlShortenerService.createShortUrl(USER_ID, request);

        assertNotNull(response);
        assertEquals(savedUrlEntity, response);
        verify(urlShortenerRepository, times(1)).findAllByUserId(USER_ID);
        verify(urlRequestConverter, times(1)).convert(USER_ID, SHORT_URL, request);
        verify(urlShortenerRepository, times(1)).save(urlEntity);
    }

    @Test
    public void testGetLongUrlByShortUrl() {
        UrlLongRequest urlLongRequest = new UrlLongRequest();
        urlLongRequest.setShortUrl(SHORT_URL);

        Optional<UrlEntity> optUrlEntity = Optional.of(new UrlEntity());
        optUrlEntity.get().setLongUrl(LONG_URL);

        when(urlShortenerRepository.findByShortUrl(urlLongRequest.getShortUrl())).thenReturn(optUrlEntity);

        UrlEntity response = urlShortenerService.getLongUrlByShortUrl(urlLongRequest);

        assertNotNull(response);
        assertEquals(optUrlEntity.get().getLongUrl(), response.getLongUrl());

        verify(urlShortenerRepository, times(1)).findByShortUrl(urlLongRequest.getShortUrl());
    }

    @Test
    public void testGetLongUrlByShortUrlFail() {
        UrlLongRequest urlLongRequest = new UrlLongRequest();
        urlLongRequest.setShortUrl(SHORT_URL);

        doThrow(new EntityNotFoundException("Url not found")).when(urlShortenerRepository).findByShortUrl(urlLongRequest.getShortUrl());

        assertThrows(EntityNotFoundException.class, () -> urlShortenerService.getLongUrlByShortUrl(urlLongRequest));
        verify(urlShortenerRepository, times(1)).findByShortUrl(urlLongRequest.getShortUrl());
    }

    @Test
    public void testGetAllUrl() {
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setLongUrl(LONG_URL);
        urlEntity.setShortUrl(SHORT_URL);
        urlEntity.setUserId(USER_ID);

        List<UrlEntity> urlList = new ArrayList<>();
        urlList.add(urlEntity);

        when(urlShortenerRepository.findAllByUserId(USER_ID)).thenReturn(urlList);

        List<UrlEntity> response = urlShortenerService.getAllUrl(USER_ID);

        assertNotNull(response);
        verify(urlShortenerRepository, times(1)).findAllByUserId(USER_ID);
    }

    @Test
    public void testGetUrl() {
        Optional<UrlEntity> optUrlEntity = Optional.of(new UrlEntity());
        optUrlEntity.get().setShortUrl(SHORT_URL);
        optUrlEntity.get().setLongUrl(LONG_URL);
        optUrlEntity.get().setUserId(USER_ID);
        optUrlEntity.get().setId(1L);

        when(urlShortenerRepository.findById(1L)).thenReturn(optUrlEntity);

        UrlEntity response = urlShortenerService.getUrl(USER_ID, 1L);

        assertNotNull(response);
        assertEquals(optUrlEntity.get(), response);
        verify(urlShortenerRepository, times(1)).findById(1L);
    }

}