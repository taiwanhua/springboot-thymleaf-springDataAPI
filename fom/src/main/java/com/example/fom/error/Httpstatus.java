package com.example.fom.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)//不管何種錯誤，獎導向404 not found頁面
public class Httpstatus extends RuntimeException {
    public Httpstatus() {
    }

    public Httpstatus(String message) {
        super(message);
    }

    public Httpstatus(String message, Throwable cause) {
        super(message, cause);
    }
}
