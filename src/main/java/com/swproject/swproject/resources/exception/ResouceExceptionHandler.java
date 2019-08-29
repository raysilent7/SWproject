package com.swproject.swproject.resources.exception;

import com.swproject.swproject.services.exception.BadRequestException;
import com.swproject.swproject.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResouceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardErrorMsg> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardErrorMsg err = new StandardErrorMsg(System.currentTimeMillis(), status.value()
                , e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardErrorMsg> badRequest(BadRequestException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardErrorMsg err = new StandardErrorMsg(System.currentTimeMillis(), status.value(),
                 e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
