package me.rolandliedtke.interviewapi.advice;

import me.rolandliedtke.interviewapi.exception.CompanyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CompanyAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured. Message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(CompanyNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occured. Message: " + ex.getLocalizedMessage());
    }
}