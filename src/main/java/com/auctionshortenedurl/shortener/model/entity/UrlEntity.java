package com.auctionshortenedurl.shortener.model.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.auctionshortenedurl.shortener.model.entity.schema.UrlEntitySchema.*;

@Entity
@Table(name = TABLE_NAME)
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = USER_ID)
    private Long userId;

    @Column(name = LONG_URL)
    private String longUrl;

    @Column(name = SHORT_URL)
    private String shortUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
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
        UrlEntity urlEntity = (UrlEntity) o;
        return Objects.equals(id, urlEntity.id) && Objects.equals(userId, urlEntity.userId)
            && Objects.equals(longUrl, urlEntity.longUrl) && Objects.equals(shortUrl,
            urlEntity.shortUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, longUrl, shortUrl);
    }

    @Override
    public String toString() {
        return "UrlEntity{" +
            "id=" + id +
            ", userId=" + userId +
            ", longUrl='" + longUrl + '\'' +
            ", shortUrl='" + shortUrl + '\'' +
            '}';
    }
}
