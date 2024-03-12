package br.edu.fatecsjc.lgnspringapi.resource.advice;

import br.edu.fatecsjc.lgnspringapi.dto.ApiErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GenericResourceExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class, Error.class})
    public ResponseEntity<ApiErrorDTO> catchExceptionReturningBadRequest(HttpServletRequest req, Exception exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiErrorDTO.builder()
                    .message("An unknown error occurred in API processing")
                    .timestamp(Instant.now())
                    .build()
        );
    }
}
