package store.management.tool.exception.errors;

import java.time.LocalDateTime;

public record ResourceNotFoundErrorDetails(LocalDateTime timestamp, String message, String path) implements ErrorDetails {
    @Override
    public String errorCode() {
        return "RESOURCE_NOT_FOUND";
    }
}
