package com.auctionshortenedurl.shortener.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.auctionshortenedurl.AuctionShortenedUrlApplication;
import com.auctionshortenedurl.shortener.service.UrlShortenerService;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuctionShortenedUrlApplication.class)
@WebAppConfiguration
public class UrlShortenerControllerTest {

    private static final String LONG_URL = "https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular";
    private static final Long USER_ID = 3L;
    private static MediaType CONTENT_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype());

    private MockMvc mockMvc;

    @SuppressWarnings("rawtypes")
    private HttpMessageConverter httpMessageConverter;

    @Autowired
    private UrlShortenerService urlShortenerService;

    @Autowired
    public void setConverters(HttpMessageConverter<?>[] converters) {
        httpMessageConverter = Arrays.asList(converters)
            .stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        Assert.assertNotNull("the JSON converter must not be null", this.httpMessageConverter);
    }

   //@Test
   //public void testCreateShortUrl() throws Exception {
   //    UrlShortenerRequest request = new UrlShortenerRequest();
   //    request.setLongUrl(LONG_URL);

   //    mockMvc.perform(put("/user/{userId}/url/create")
   //        .contentType(CONTENT_TYPE)
   //        .content(json())
   //    )

   //}
}