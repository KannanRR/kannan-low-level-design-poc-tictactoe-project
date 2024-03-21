package com.poc.lowleveldesign.tictactoe.v1;

import com.poc.lowleveldesign.tictactoe.v1.strategies.winning.RowWinningStrategy;
import com.poc.lowleveldesign.tictactoe.v1.strategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Players> players = new ArrayList<>();
    private int nextPlayerIndex = 0;
    private GameStatus status;
    private Players winner;

    private List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy());

    private Game() {

    }

    public Board getBoard() {
        return board;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void start() {
        // Assign a random value to the nextPlayerIndex
        // Random value -> 0 or 1
        // 0.5 * 2 = 1.0 = 1
        // 0.1 * 2 = 0.2 = 0
        // 0.8 * 2 = 1.6 = 1
        nextPlayerIndex = (int) (Math.random() * players.size());
        setNextPlayerIndex(nextPlayerIndex);

        // Set the status to IN_PROGRESS
        status = GameStatus.IN_PROGRESS;
        setStatus(status);
    }

    public void makeMove() {

        players.get(getNextPlayerIndex()).makeMove(board);
        boolean winner = checkWinner(board, players.get(getNextPlayerIndex()).getSymbol());

        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        setNextPlayerIndex(nextPlayerIndex);
    }

    private boolean checkWinner(Board board, GameSymbol symbol) {
        for (WinningStrategy strategy : winningStrategies) {
            if (strategy.checkWinner(board,symbol)) {
                setStatus(GameStatus.FINISHED);
                setWinner(players.get(getNextPlayerIndex()));
                return true;
            }
        }

        return false;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Players getWinner() {
        return winner;
    }

    public void setWinner(Players winner) {
        this.winner = winner;
    }

    public static class Builder {
        private Game game;
        public Builder() {
            this.game = new Game();
        }

        public Builder withSize(int size) {
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Players player) {
            this.game.getPlayers().add(player);
            return this;
        }

        public Game build() {
            Game newgame = new Game();
            newgame.board = this.game.board;
            newgame.players = this.game.players;

            return newgame;
        }
    }
}
