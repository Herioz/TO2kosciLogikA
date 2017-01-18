package pl.edu.agh.to2.grawgre.model;

import java.util.List;

/**
 * Created by pawel on 05.01.17.
 */
public class GameState {
    private List<Player> listOfPlayers;
    private GameStatus status;
    private String activePlayer;
    private Integer winningNumber;
    private Integer numberOfPointsToWin;

    public GameState(List<Player> listOfPlayers, GameStatus status, String activePlayer) {
        this.listOfPlayers = listOfPlayers;
        this.status = status;
        this.activePlayer = activePlayer;
    }

    public GameState(){}

    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public String getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(String activePlayer) {
        this.activePlayer = activePlayer;
    }

    public Integer getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(Integer winningNumber) {
        this.winningNumber = winningNumber;
    }

    public Integer getNumberOfPointsToWin() {
        return numberOfPointsToWin;
    }

    public void setNumberOfPointsToWin(Integer numberOfPointsToWin) {
        this.numberOfPointsToWin = numberOfPointsToWin;
    }
}
