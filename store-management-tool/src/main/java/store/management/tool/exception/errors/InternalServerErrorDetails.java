package store.management.tool.exception.errors;


import java.time.LocalDateTime;

public record InternalServerErrorDetails(LocalDateTime timestamp, String message, String path) implements ErrorDetails {
    @Override
    public String errorCode() {
        return "INTERNAL_SERVER_ERROR";
    }
}