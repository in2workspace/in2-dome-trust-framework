package es.in2.trustframework.api.exception.handler;

import es.in2.trustframework.api.exception.IssuerRecordNotFoundException;
import es.in2.trustframework.api.model.dto.GlobalErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.Date;
import java.util.UUID;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CredentialNotFoundException.class)
    public ResponseEntity<GlobalErrorMessage> handleCredentialNotFound(CredentialNotFoundException ex) {
        return handleException(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IssuerRecordNotFoundException.class)
    public ResponseEntity<GlobalErrorMessage> handleCredentialNotFound(IssuerRecordNotFoundException ex) {
        return handleException(ex, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<GlobalErrorMessage> handleException(Exception ex, HttpStatus status) {
        String errorId = UUID.randomUUID().toString();
        GlobalErrorMessage globalErrorMessage = new GlobalErrorMessage(
                new Date(),
                errorId,
                ex.getMessage());
        log.error("Error ID: {}", errorId, ex);
        return ResponseEntity.status(status).body(globalErrorMessage);
    }

}
