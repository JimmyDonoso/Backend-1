package com.example.proyectoClinica;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExcepcionGlobal {
    private static final Logger logger = Logger.getLogger(ExcepcionGlobal.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allError(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return new ResponseEntity("Hubo un error", HttpStatus.NOT_FOUND);
    }
}
