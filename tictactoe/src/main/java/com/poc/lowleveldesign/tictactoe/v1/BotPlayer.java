package com.poc.lowleveldesign.tictactoe.v1;

import com.poc.lowleveldesign.tictactoe.v1.strategies.playing.PlayingStrategy;

public class BotPlayer extends Players {

    private PlayingStrategy playingStrategy;
    private GameLevel gamelevel;

    private BotPlayer() {

    }
    private BotPlayer(GameSymbol symbol, PlayingStrategy playingStrategy, GameLevel gamelevel) {
        super(symbol);
        this.playingStrategy = playingStrategy;
        this.gamelevel = gamelevel;
    }

    @Override
    void makeMove(Board board) {
        //System.out.println("Bot Player Move");
        playingStrategy.makeMove(board, this.getSymbol());

    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BotPlayer botplayer;

        public Builder() {
            this.botplayer = new BotPlayer();
        }

        public Builder setSymbol(GameSymbol symbol) {
            this.botplayer.symbol = symbol;
            return this;
        }

        public Builder setGamelevel(GameLevel level) {
            this.botplayer.gamelevel = level;
            return this;
        }

        public Builder setPlayingstrategy(PlayingStrategy playingStrategy) {
            this.botplayer.playingStrategy = playingStrategy;
            return this;
        }

        public BotPlayer build() {
            return new BotPlayer(this.botplayer.symbol,this.botplayer.playingStrategy,this.botplayer.gamelevel);
        }
    }
}
