package pl.edu.agh.to2.grawgre.container;

import pl.edu.agh.to2.grawgre.model.Configuration;

import java.io.Serializable;

/**
 * Created by pawel on 05.01.17.
 */
public class CreateGameContainer {
    private String nick;
    private Configuration configuration;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public CreateGameContainer(String nick, Configuration configuration) {

        this.nick = nick;
        this.configuration = configuration;
    }

    public CreateGameContainer(){}
}
