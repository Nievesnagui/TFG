package net.ausiasmarch.weekeat.exception;

public class CannotPerformOperationException extends RuntimeException {
    
    public CannotPerformOperationException(String msg) {
        super("ERROR: Cannot perform operation: " + msg);
    }

}