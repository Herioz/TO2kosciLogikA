package model;

/**
 * Created by Kamil on 2016-12-29.
 */
public class Game {
    private Integer gameID;
    private GameType gameType;
    private Integer placesLeft;
    private GameState gameState;

    public Game(Integer gameID, GameType gameType, Integer placesLeft, GameState gameState) {
        this.gameID = gameID;
        this.gameType = gameType;
        this.placesLeft = placesLeft;
        this.gameState = gameState;
    }
     public void d(){}
    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Integer getPlacesLeft() {
        return placesLeft;
    }

    public void setPlacesLeft(Integer placesLeft) {
        this.placesLeft = placesLeft;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


}
