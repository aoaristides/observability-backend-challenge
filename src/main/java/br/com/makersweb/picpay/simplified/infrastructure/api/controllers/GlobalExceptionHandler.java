package br.com.makersweb.picpay.simplified.infrastructure.api.controllers;

import br.com.makersweb.picpay.simplified.domain.exceptions.DomainException;
import br.com.makersweb.picpay.simplified.domain.exceptions.DuplicateViolationException;
import br.com.makersweb.picpay.simplified.domain.exceptions.NotFoundException;
import br.com.makersweb.picpay.simplified.domain.validation.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;

/**
 * @author aaristides
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(final NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiError.from(ex));
    }

    @ExceptionHandler(value = DomainException.class)
    public ResponseEntity<?> handleDomainException(final DomainException ex) {
        return ResponseEntity.unprocessableEntity().body(ApiError.from(ex));
    }

    @ExceptionHandler(value = DuplicateViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(final DuplicateViolationException ex) {
        return ResponseEntity.badRequest().body(ApiError.from(ex));
    }

    record ApiError(String message, List<Error> errors) {
        static ApiError from(final DomainException ex) {
            return new ApiError(ex.getMessage(), ex.getErrors());
        }
    }

}
