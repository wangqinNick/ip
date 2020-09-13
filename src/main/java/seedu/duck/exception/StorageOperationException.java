package seedu.duck.exception;

import java.io.IOException;

public class StorageOperationException extends IOException {
    public StorageOperationException(String message) {
        super(message);
    }
}
