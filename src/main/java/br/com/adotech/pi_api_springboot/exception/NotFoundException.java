package br.com.adotech.pi_api_springboot.exception;

public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
