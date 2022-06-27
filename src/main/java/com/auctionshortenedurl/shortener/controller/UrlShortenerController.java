package com.auctionshortenedurl.shortener.controller;


import com.auctionshortenedurl.shortener.converter.UrlResponseConverter;
import com.auctionshortenedurl.shortener.model.dto.UrlDto;
import com.auctionshortenedurl.shortener.model.request.UrlLongRequest;
import com.auctionshortenedurl.shortener.model.request.UrlShortenerRequest;
import com.auctionshortenedurl.shortener.service.UrlShortenerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.auctionshortenedurl.shortener.controller.endpoint.UrlShortenerControllerEndpoint.*;

@RestController
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;
    private final UrlResponseConverter urlResponseConverter;

    public UrlShortenerController(
        UrlShortenerService urlShortenerService,
        UrlResponseConverter urlResponseConverter) {
        this.urlShortenerService = urlShortenerService;
        this.urlResponseConverter = urlResponseConverter;
    }

    @PostMapping(value = CREATE)
    public UrlDto createShortUrl(@PathVariable Long userId, @RequestBody @Valid UrlShortenerRequest request) {
        return urlResponseConverter.convert(urlShortenerService.createShortUrl(userId, request));
    }

    @GetMapping(value = GET_LONG_URL)
    public UrlDto getLongUrlByShortUrl(@ModelAttribute @Valid UrlLongRequest request) {
        return urlResponseConverter.convert(urlShortenerService.getLongUrlByShortUrl(request));
    }

    @GetMapping(value = GET_ALL_URL)
    public List<UrlDto> getAllUrl(@PathVariable Long userId) {
        return urlResponseConverter.convert(userId, urlShortenerService.getAllUrl(userId));
    }

    @GetMapping(value = GET_URL)
    public UrlDto getUrl(@PathVariable Long userId, @PathVariable Long urlId) {
        return urlResponseConverter.convert(urlShortenerService.getUrl(userId, urlId));
    }

    @DeleteMapping(value = DELETE_URL)
    public void deleteUrl(@PathVariable Long userId, @PathVariable Long urlId) {
        urlShortenerService.deleteUrl(userId, urlId);
    }
}
