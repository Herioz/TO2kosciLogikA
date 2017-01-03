package model;

import java.util.List;

/**
 * Created by Kamil on 2016-12-29.
 */
public class Configuration {
    private GameType gameType;
    private Integer numberOfPointsToWin;
    private List<BotConfiguration> listOfBots;
    private Integer humansNum;

    public Configuration(GameType gameType, Integer numberOfPointsToWin, List<BotConfiguration> listOfBots, Integer humansNum) {
        this.gameType = gameType;
        this.numberOfPointsToWin = numberOfPointsToWin;
        this.listOfBots = listOfBots; // XD?
        this.humansNum = humansNum;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Integer getNumberOfPointsToWin() {
        return numberOfPointsToWin;
    }

    public void setNumberOfPointsToWin(Integer numberOfPointsToWin) {
        this.numberOfPointsToWin = numberOfPointsToWin;
    }

    public List<BotConfiguration> getListOfBots() {
        return listOfBots;
    }

    public void setListOfBots(List<BotConfiguration> listOfBots) {
        this.listOfBots = listOfBots;
    }

    public Integer getHumansNum() {
        return humansNum;
    }

    public void setHumansNum(Integer humansNum) {
        this.humansNum = humansNum;
    }
}
