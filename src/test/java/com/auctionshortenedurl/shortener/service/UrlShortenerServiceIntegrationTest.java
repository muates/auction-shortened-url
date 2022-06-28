package com.auctionshortenedurl.shortener.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.auctionshortenedurl.shortener.model.entity.UrlEntity;
import com.auctionshortenedurl.shortener.model.request.UrlLongRequest;
import com.auctionshortenedurl.shortener.model.request.UrlShortenerRequest;
import com.auctionshortenedurl.shortener.service.impl.UrlShortenerServiceImpl;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UrlShortenerServiceIntegrationTest {

    private static final String LONG_URL = "https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular2";
    private static final String SHORT_URL = "http://localhost:8080/1833663953";
    private static final Long USER_ID = 3L;
    private static final Long URL_ID = 8L;

    @Autowired
    private UrlShortenerServiceImpl urlShortenerService;

    @Test
    public void testCreateShortUrl() {
        UrlShortenerRequest request = new UrlShortenerRequest();
        request.setLongUrl(LONG_URL);

        UrlEntity response = urlShortenerService.createShortUrl(USER_ID, request);

        assertNotNull(response);
        assertTrue(response.getId() > 0);
    }

    @Test
    public void testGetLongUrlByShortUrl() {
        UrlLongRequest request = new UrlLongRequest();
        request.setShortUrl(SHORT_URL);

        UrlEntity response = urlShortenerService.getLongUrlByShortUrl(request);

        assertNotNull(response);
        assertNotNull(response.getLongUrl());
    }

    @Test
    public void testGetAllUrl() {
        List<UrlEntity> response = urlShortenerService.getAllUrl(USER_ID);

        assertNotNull(response);
        assertEquals(USER_ID, response.get(0).getUserId());
    }

    @Test
    public void testGetUrl() {
        UrlEntity response = urlShortenerService.getUrl(USER_ID, URL_ID);

        assertNotNull(response);
        assertEquals(USER_ID, response.getUserId());
    }

}
