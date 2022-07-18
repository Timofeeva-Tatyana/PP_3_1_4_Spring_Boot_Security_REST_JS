package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.exception_handling;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException(String message) {
        super(message);
    }
}
