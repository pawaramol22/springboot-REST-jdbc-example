package com.myspringboot.example.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String key) {
        super("Could not find Issue " + key);
    }
}
