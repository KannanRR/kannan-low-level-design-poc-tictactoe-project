package com.poc.lowleveldesign.tictactoe.v1;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    List<List<GameSymbol>> boardcells = new ArrayList<>();

    public List<List<GameSymbol>> getBoardcells() {
        return this.boardcells;
    }

    public int getSize() {
        return size;
    }

    public Board(int size) {
        this.size = size;
        this.boardcells = initialiseCells(this.size);
    }

    private List<List<GameSymbol>> initialiseCells(int size) {
        List<List<GameSymbol>> cells = new ArrayList<>();
        for (int i=0; i < size; i++) {
            cells.add(new ArrayList<GameSymbol>());
            for (int j=0; j < size; j++) {
                cells.get(i).add(j,null);
            }
        }

        return cells;
    }

    public void printBoard() {

        for (int i=0; i < this.boardcells.size(); i++) {
            for (int j=0; j < this.boardcells.size(); j++) {
                if (this.boardcells.get(i).get(j) == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + this.boardcells.get(i).get(j) + " | ");
                }
            }
            System.out.printf("\n");
        }
    }
}
