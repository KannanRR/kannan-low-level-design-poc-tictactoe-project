package com.poc.lowleveldesign.tictactoe.v1.strategies.playing;

import com.poc.lowleveldesign.tictactoe.v1.Board;
import com.poc.lowleveldesign.tictactoe.v1.GameSymbol;

public interface PlayingStrategy {
    void makeMove(Board board, GameSymbol symbol);
}
