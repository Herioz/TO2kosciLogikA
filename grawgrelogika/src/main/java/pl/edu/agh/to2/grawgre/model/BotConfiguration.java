package pl.edu.agh.to2.grawgre.model;

/**
 * Created by pawel on 05.01.17.
 */
public class BotConfiguration {
    private String name;
    private BotLevel botLevel;

    public BotConfiguration(String name, BotLevel botLevel) {
        this.name = name;
        this.botLevel = botLevel;
    }

    public BotConfiguration(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BotLevel getBotLevel() {
        return botLevel;
    }

    public void setBotLevel(BotLevel botLevel) {
        this.botLevel = botLevel;
    }
}
