package com.bibliotekarze.libraryrest.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserErrorResponse {

    private int status;
    private String message;
    private long timestamp;

    public UserErrorResponse() {
    }

    public UserErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
