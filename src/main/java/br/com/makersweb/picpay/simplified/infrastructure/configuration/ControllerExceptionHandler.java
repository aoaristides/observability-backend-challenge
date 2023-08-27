package br.com.makersweb.picpay.simplified.infrastructure.configuration;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author aaristides
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception) {
//        var exceptionDTO = new ExceptionDTO("Usuário já cadastrado.", "400");
//        return ResponseEntity.badRequest().body(exceptionDTO);
//    }
//
//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity threat404(EntityNotFoundException exception) {
//        return ResponseEntity.notFound().build();
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity threatGeneralException(Exception exception) {
//        var exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
//        return ResponseEntity.internalServerError().body(exceptionDTO);
//    }

}
