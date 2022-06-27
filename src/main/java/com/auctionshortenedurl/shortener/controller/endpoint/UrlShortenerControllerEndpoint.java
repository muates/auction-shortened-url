package com.auctionshortenedurl.shortener.controller.endpoint;

public class UrlShortenerControllerEndpoint {
    public static final String CREATE = "/user/{userId}/url/create";
    public static final String GET_LONG_URL = "/user/url";
    public static final String GET_ALL_URL = "/user/{userId}/url/list";
    public static final String GET_URL = "/user/{userId}/url/detail/{urlId}";
    public static final String DELETE_URL = "/user/{userId}/url/detail/{urlId}";
}
