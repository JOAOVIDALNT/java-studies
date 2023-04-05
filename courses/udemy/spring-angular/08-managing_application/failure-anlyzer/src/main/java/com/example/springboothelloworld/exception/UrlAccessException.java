package com.example.springboothelloworld.exception;

public class UrlAccessException extends RuntimeException {

    private String url;

    public UrlAccessException(String url) {
        this(url, null);
    }

    public UrlAccessException(String url, Throwable cause) {
        super("URL " + url + " is not accessible ", cause);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
