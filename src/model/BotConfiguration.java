package model;

/**
 * Created by Kamil on 2016-12-29.
 */
public class BotConfiguration {
    private String name;
    private BotLevel botLevel;

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
