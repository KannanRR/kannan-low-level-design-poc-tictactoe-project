package com.poc.lowleveldesign.tictactoe.v1.strategies.playing;

import com.poc.lowleveldesign.tictactoe.v1.Board;
import com.poc.lowleveldesign.tictactoe.v1.GameSymbol;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public void makeMove(Board board, GameSymbol symbol) {
        int size = board.getBoardcells().size();

        breakloop:
        for (int i=0; i < size; i++) {
            for (int j=0; j < size; j++) {
                if (board.getBoardcells().get(i).get(j) == null) {
                    board.getBoardcells().get(i).set(j, symbol);
                    break breakloop;
                }
            }
        }
    }
}