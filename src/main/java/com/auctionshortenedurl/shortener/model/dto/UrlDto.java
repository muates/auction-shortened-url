package com.auctionshortenedurl.shortener.model.dto;

import java.util.Objects;

public class UrlDto {

    private Long id;
    private String shortUrl;
    private String longUrl;

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

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UrlDto urlDto = (UrlDto) o;
        return Objects.equals(id, urlDto.id) && Objects.equals(shortUrl, urlDto.shortUrl)
            && Objects.equals(longUrl, urlDto.longUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortUrl, longUrl);
    }

    @Override
    public String toString() {
        return "UrlDto{" +
            "id=" + id +
            ", shortUrl='" + shortUrl + '\'' +
            ", longUrl='" + longUrl + '\'' +
            '}';
    }
}
