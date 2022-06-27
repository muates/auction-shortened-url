package com.auctionshortenedurl.shortener.model.request;

import java.util.Objects;
import javax.validation.constraints.NotBlank;

public class UrlShortenerRequest {

    @NotBlank
    private String longUrl;

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
        UrlShortenerRequest that = (UrlShortenerRequest) o;
        return Objects.equals(longUrl, that.longUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longUrl);
    }

    @Override
    public String toString() {
        return "UrlShortenerRequest{" +
            "longUrl='" + longUrl + '\'' +
            '}';
    }
}
