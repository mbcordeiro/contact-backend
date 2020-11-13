package com.matheuscordeiro.contact.exceptions;

public class AuthenticationErrorException extends RuntimeException{
    public AuthenticationErrorException(String e) {
        super(e);
    }
}
