package store.management.tool.exception.errors;


import java.time.LocalDateTime;

public record ValidationErrorDetails(LocalDateTime timestamp, String message, String path) implements ErrorDetails {
    @Override
    public String errorCode() {
        return "VALIDATION_FAILED";
    }
}