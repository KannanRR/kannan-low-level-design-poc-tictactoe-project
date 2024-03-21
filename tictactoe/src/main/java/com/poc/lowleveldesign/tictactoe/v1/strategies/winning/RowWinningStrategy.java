package com.poc.lowleveldesign.tictactoe.v1.strategies.winning;

import com.poc.lowleveldesign.tictactoe.v1.Board;
import com.poc.lowleveldesign.tictactoe.v1.GameSymbol;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol symbol) {

        int size = board.getBoardcells().size();
        // Check if all the symbols in the same row are the same
        for (int row=0; row < size; row++) {
            boolean isWinner = true;
            for (int col=0; col < size; col++) {
                if (board.getBoardcells().get(row).get(col) != symbol) {
                    isWinner = false;
                    break;
                }
            }

            if (isWinner) {
                return true;
            }
        }

        return false;
    }
}
