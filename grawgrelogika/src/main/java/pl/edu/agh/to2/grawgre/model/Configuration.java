package pl.edu.agh.to2.grawgre.model;

import java.util.List;

/**
 * Created by pawel on 05.01.17.
 */
public class Configuration {
    private GameType gameType;
    private Integer numberOfPointsToWin;
    private List<BotConfiguration> listOfBots;
    private Integer humansNum;

    public Configuration(GameType gameType, Integer numberOfPointsToWin, List<BotConfiguration> listOfBots, Integer humansNum) {
        this.gameType = gameType;
        this.numberOfPointsToWin = numberOfPointsToWin;
        this.listOfBots = listOfBots;
        this.humansNum = humansNum;
    }

    public Configuration(){}

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
