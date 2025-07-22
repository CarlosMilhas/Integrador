package com.talentoTech.milhas.Integrador.exceptions;

public class NoStockException extends Throwable {
    private String message;

    public NoStockException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}