package com.poc.lowleveldesign.tictactoe.v1;

public abstract class Players {

    GameSymbol symbol;

    public Players() {
    }

    public Players(GameSymbol symbol) {
        this.symbol = symbol;
    }

    public GameSymbol getSymbol() {
        return symbol;
    }

    abstract void makeMove(Board board);

}
