package com.poc.lowleveldesign.tictactoe.v1;

import com.poc.lowleveldesign.tictactoe.v1.exceptions.InvalidMoveException;

import java.util.Scanner;

public class HumanPlayer extends Players {

    private String name;
    private String email;

    public HumanPlayer(String name, String email, GameSymbol symbol) {
        super(symbol);
        this.name = name;
        this.email = email;
    }

    @Override
    void makeMove(Board board) {

        Scanner cellInput = new Scanner(System.in);
        System.out.println("Enter Row and Column cells");
        int row = cellInput.nextInt();
        int col = cellInput.nextInt();

        if (board.getBoardcells().get(row).get(col) == null) {
            board.getBoardcells().get(row).set(col, this.getSymbol());
        } else {
            throw new InvalidMoveException("Invalid Move");
        }
    }
}
