package guru.springframework.spring7restmvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "resource not found")
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }
}
