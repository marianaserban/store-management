package store.management.tool.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import store.management.tool.exception.errors.ErrorDetails;
import store.management.tool.exception.errors.InternalServerErrorDetails;
import store.management.tool.exception.errors.ResourceNotFoundErrorDetails;
import store.management.tool.exception.errors.ValidationErrorDetails;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException  ex,
                                                                HttpServletRequest request) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error->error.getDefaultMessage())
                .collect(Collectors.joining(";"));

        ErrorDetails errorDetails = new ValidationErrorDetails(
                LocalDateTime.now(),
                message,
                request.getRequestURI()
        );

        logger.warn("Handled DTO validation error: {}", errorDetails);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        HttpServletRequest request){

        ErrorDetails errorDetails = new ResourceNotFoundErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getRequestURI()
        );
        logger.warn("Handled resource not found error: {}", errorDetails);

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
                                                              HttpServletRequest request){

        ErrorDetails errorDetails = new InternalServerErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getRequestURI()
        );


        logger.error("Unexpected internal server error: {}", errorDetails);

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
