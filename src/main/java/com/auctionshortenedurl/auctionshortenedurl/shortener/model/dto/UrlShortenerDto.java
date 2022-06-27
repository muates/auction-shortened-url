package com.auctionshortenedurl.auctionshortenedurl.shortener.model.dto;

import java.util.Objects;

public class UrlShortenerDto {

    private Long id;
    private String shortUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UrlShortenerDto urlShortenerDto = (UrlShortenerDto) o;
        return Objects.equals(id, urlShortenerDto.id) && Objects.equals(shortUrl, urlShortenerDto.shortUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortUrl);
    }

    @Override
    public String toString() {
        return "UrlDto{" +
            "id=" + id +
            ", shortId='" + shortUrl + '\'' +
            '}';
    }
}
