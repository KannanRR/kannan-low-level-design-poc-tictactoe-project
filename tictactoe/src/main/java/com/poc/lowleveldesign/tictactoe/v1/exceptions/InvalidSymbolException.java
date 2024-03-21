package com.poc.lowleveldesign.tictactoe.v1.exceptions;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException(String msg) {
        super(msg);
    }
}
