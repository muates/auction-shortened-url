package com.auctionshortenedurl.auctionshortenedurl.shortener.model.request;

import java.util.Objects;
import javax.validation.constraints.NotBlank;

public class UrlLongRequest {

    @NotBlank
    private String shortUrl;

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
        UrlLongRequest that = (UrlLongRequest) o;
        return Objects.equals(shortUrl, that.shortUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortUrl);
    }

    @Override
    public String toString() {
        return "UrlLongRequest{" +
            "shortUrl='" + shortUrl + '\'' +
            '}';
    }
}
