package com.ar.session.Aang.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EnableException extends Exception{
    public EnableException(String message){
        super(message);
    }
}
