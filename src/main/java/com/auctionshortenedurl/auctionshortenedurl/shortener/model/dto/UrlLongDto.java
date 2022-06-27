package com.auctionshortenedurl.auctionshortenedurl.shortener.model.dto;

import java.util.Objects;

public class UrlLongDto {

    private Long id;
    private String LongUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return LongUrl;
    }

    public void setLongUrl(String longUrl) {
        LongUrl = longUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UrlLongDto that = (UrlLongDto) o;
        return Objects.equals(id, that.id) && Objects.equals(LongUrl, that.LongUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, LongUrl);
    }

    @Override
    public String toString() {
        return "UrlLongDto{" +
            "id=" + id +
            ", LongUrl='" + LongUrl + '\'' +
            '}';
    }
}
