package com.beatriz.api_pet.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message){
        super(message);
    }
}
