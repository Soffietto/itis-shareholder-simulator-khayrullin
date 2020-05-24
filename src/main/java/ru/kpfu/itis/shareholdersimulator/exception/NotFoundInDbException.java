package ru.kpfu.itis.shareholdersimulator.exception;

public class NotFoundInDbException extends RuntimeException{

    private static final String MESSAGE = "Entity not found";

    public NotFoundInDbException() {
        super(MESSAGE);
    }
}
