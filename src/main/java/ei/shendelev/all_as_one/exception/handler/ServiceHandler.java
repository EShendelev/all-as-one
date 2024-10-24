package ei.shendelev.all_as_one.exception.handler;

import ei.shendelev.all_as_one.exception.NotFoundException;
import ei.shendelev.all_as_one.exception.NotUniqueException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestControllerAdvice
public class ServiceHandler {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler({MissingRequestHeaderException.class, MethodArgumentNotValidException.class,
            BadRequestException.class, ConstraintViolationException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(final Exception e) {
        log.error("{} - Status: {}, Description: {}, Timestamp: {}", "Bad Request", HttpStatus.BAD_REQUEST,
                e.getMessage(), LocalDateTime.now());

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.name(), e.getMessage(),
                "Bad Request", LocalDateTime.now().format(FORMATTER));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInternalServerError(final Exception e) {
        log.error("{} - Status: {}, Description: {}, Timestamp: {}",
                "SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getMessage(),
                "Internal Server Error", LocalDateTime.now().format(FORMATTER)), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler({DataIntegrityViolationException.class, NotUniqueException.class})
    public ResponseEntity<ErrorResponse> handleConflict(final Exception e) {
        log.error("{} - Status: {}, Description: {}, Timestamp: {}",
                "CONFLICT", HttpStatus.CONFLICT, e.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT.name(), e.getMessage(),
                "Data Integrity constraint violation occurred", LocalDateTime.now().format(FORMATTER)),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFound(final RuntimeException e) {
        log.error("{} - Status: {}, Description: {}, Timestamp: {}",
                "NOT FOUND", HttpStatus.NOT_FOUND, e.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.name(), e.getMessage(),
                "Not Found", LocalDateTime.now().format(FORMATTER)), HttpStatus.NOT_FOUND);
    }

}
