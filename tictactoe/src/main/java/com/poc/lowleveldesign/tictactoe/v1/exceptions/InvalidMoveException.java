package com.poc.lowleveldesign.tictactoe.v1.exceptions;

public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(String msg) {
        super(msg);
    }
}
