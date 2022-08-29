package com.example.newjiraback.exception;

public class TodoNotFoundException extends Exception {

    public TodoNotFoundException() {
        super("Todo not found");
    }
}
