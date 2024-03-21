package com.poc.lowleveldesign.tictactoe.v1.strategies.winning;

import com.poc.lowleveldesign.tictactoe.v1.Board;
import com.poc.lowleveldesign.tictactoe.v1.GameSymbol;

public interface WinningStrategy {
    boolean checkWinner(Board board, GameSymbol symbol);
}
