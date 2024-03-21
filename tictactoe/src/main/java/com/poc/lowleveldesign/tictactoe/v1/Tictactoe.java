package com.poc.lowleveldesign.tictactoe.v1;

import com.poc.lowleveldesign.tictactoe.v1.exceptions.InvalidSymbolException;
import com.poc.lowleveldesign.tictactoe.v1.strategies.playing.RandomPlayingStrategy;

import java.util.Scanner;

public class Tictactoe {
    private static final int BOARD_SIZE = 3;
    private static int nextPlayerIndex = 0;

    public static void main(String[] args) {

        System.out.println("Tictactoe Implementation");

        HumanPlayer humanUser = getHumanuserInput();
        Game game = creategame(humanUser);

        System.out.println("Board Cells");
        System.out.println(game.getBoard().getBoardcells());

        game.start();

        int i = 0;
        int Cells = game.getBoard().getSize();
        while (game.getStatus() == GameStatus.IN_PROGRESS && i < Cells*Cells) {
            game.makeMove();
            game.getBoard().printBoard();
            System.out.println("Next Player - " + game.getPlayers().get(game.getNextPlayerIndex()).getSymbol());
            i++;
        }

        if (game.getStatus() == GameStatus.FINISHED) {
            System.out.println("Player " + game.getWinner().getSymbol() + " won the Game");
        } else {
            System.out.println("Game Drawn");
        }

    }

    private static Game creategame(HumanPlayer humanUser) {
        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanUser)
                .withPlayer(
                            BotPlayer.builder()
                                    .setSymbol(decideBotsymbol(humanUser.getSymbol()))
                                    .setGamelevel(GameLevel.EASY)
                                    .setPlayingstrategy(new RandomPlayingStrategy())
                                    .build()
                        )

                .build();
    }

    private static GameSymbol decideBotsymbol(GameSymbol symbol) {
        if (symbol == GameSymbol.X) {
            return GameSymbol.O;
        }

        return GameSymbol.X;
    }

    private static HumanPlayer getHumanuserInput() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your Name");
        String name = input.nextLine();

        System.out.println("Enter your Email");
        String email = input.nextLine();

        System.out.println("Enter symbol (O or X):");

        GameSymbol symbol;
        try {
            symbol = GameSymbol.valueOf(input.nextLine());
        } catch (IllegalArgumentException e) {
            throw new InvalidSymbolException("Enter symbol (O or X)");
        }

        return new HumanPlayer(name,email,symbol);
    }
}
