package store.management.tool.exception.errors;

import java.time.LocalDateTime;

public sealed interface ErrorDetails permits ValidationErrorDetails, ResourceNotFoundErrorDetails, InternalServerErrorDetails {
    LocalDateTime timestamp();
    String message();
    String path();
    String errorCode();
}
