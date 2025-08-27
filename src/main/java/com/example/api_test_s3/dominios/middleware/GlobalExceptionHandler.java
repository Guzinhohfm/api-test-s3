package com.example.api_test_s3.dominios.middleware;

import com.example.api_test_s3.dto.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.swing.text.html.parser.Entity;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(Exception ex, HttpServletRequest request){
        var exception = new ExceptionDto(
                                    "Erro inesperado",
                                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                    ex.getMessage(),
                                    request.getRequestURI()
                                    );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ExceptionDto> handleException(MaxUploadSizeExceededException ex, HttpServletRequest request){
        var exception = new ExceptionDto(
                "Arquivo excedido",
                HttpStatus.PAYLOAD_TOO_LARGE.value(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body(exception);
    }
}
