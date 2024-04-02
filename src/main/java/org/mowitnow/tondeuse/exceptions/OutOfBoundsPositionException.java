package org.mowitnow.tondeuse.exceptions;

public class OutOfBoundsPositionException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public OutOfBoundsPositionException(String message) {
        super(message);
    }
}