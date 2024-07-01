package com.example.CabConnect.exception;

public class CabNotAvailableException extends RuntimeException{
    public CabNotAvailableException(String message){
        super(message);
    }
}
