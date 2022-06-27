package com.auctionshortenedurl.auctionshortenedurl.shortener.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.auctionshortenedurl.auctionshortenedurl.shortener.converter.UrlRequestConverter;
import com.auctionshortenedurl.auctionshortenedurl.shortener.model.entity.UrlEntity;
import com.auctionshortenedurl.auctionshortenedurl.shortener.model.request.UrlLongRequest;
import com.auctionshortenedurl.auctionshortenedurl.shortener.model.request.UrlShortenerRequest;
import com.auctionshortenedurl.auctionshortenedurl.shortener.repository.UrlShortenerRepository;
import com.auctionshortenedurl.auctionshortenedurl.shortener.service.impl.UrlShortenerServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UrlShortenerServiceTest {

    private static final String LONG_URL = "https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular";
    private static final String SHORT_URL = "http://localhost:8080/613339777";
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
        UrlShortenerRequest urlShortenerRequest = new UrlShortenerRequest();
        urlShortenerRequest.setLongUrl(LONG_URL);

        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setShortUrl(SHORT_URL);
        urlEntity.setLongUrl(LONG_URL);
        urlEntity.setUserId(USER_ID);

        UrlEntity existUrlEntity = new UrlEntity();
        existUrlEntity.setShortUrl(SHORT_URL);
        existUrlEntity.setLongUrl(LONG_URL);
        existUrlEntity.setUserId(USER_ID);

        when(urlRequestConverter.convert(USER_ID, SHORT_URL, urlShortenerRequest)).thenReturn(urlEntity);
        when(urlShortenerRepository.save(urlEntity)).thenReturn(existUrlEntity);

        UrlEntity response = urlShortenerService.createShortUrl(USER_ID, urlShortenerRequest);

        assertNotNull(response);
        assertEquals(existUrlEntity.getShortUrl(), response.getShortUrl());

        verify(urlRequestConverter, times(1)).convert(USER_ID, SHORT_URL, urlShortenerRequest);
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