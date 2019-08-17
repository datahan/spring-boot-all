package com.datahan.springbootall.exception.handler.exception;

import com.datahan.springbootall.exception.handler.constant.Status;
import lombok.Getter;

@Getter
public class JsonException extends BaseException {

    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
