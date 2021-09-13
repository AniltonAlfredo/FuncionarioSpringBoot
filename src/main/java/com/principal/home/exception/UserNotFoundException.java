package com.principal.home.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mensagem) {
        super(mensagem);
    }
}
