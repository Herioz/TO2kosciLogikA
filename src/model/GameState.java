package model;

import java.util.List;

/**
 * Created by Kamil on 2016-12-29.
 */
public class GameState {
    private List<Player> listOfPlayers;
    private GameStatus gameStatus;
    private int winningNumber = 0;
    private String activePlayer;
    private int numberOfPointsToWin;

    public GameState(List<Player> listOfPlayers, GameStatus gameStatus, int numberOfPointsToWin) {
        this.listOfPlayers = listOfPlayers;
        this.gameStatus = gameStatus;
        this.numberOfPointsToWin = numberOfPointsToWin;
    }

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getActivePlayer() {
        return activePlayer;
    }


    public void setActivePlayer(String activePlayer) {
        this.activePlayer = activePlayer;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(int winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int getNumberOfPointsToWin() {
        return numberOfPointsToWin;
    }

    public void setNumberOfPointsToWin(int numberOfPointsToWin) {
        this.numberOfPointsToWin = numberOfPointsToWin;
    }
}
