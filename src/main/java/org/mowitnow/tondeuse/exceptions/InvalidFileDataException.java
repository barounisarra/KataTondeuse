package org.mowitnow.tondeuse.exceptions;

public class InvalidFileDataException extends RuntimeException {
    private static final long serialVersionUID = 1L;

        public InvalidFileDataException(String message) {
            super(message);
        }
}
