package org.mowitnow.tondeuse.exceptions;

public class TondeuseException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public TondeuseException(String message) {
        super(message);
    }
}
