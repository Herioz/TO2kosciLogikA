package pl.edu.agh.to2.grawgre.container;

import java.io.Serializable;

/**
 * Created by pawel on 05.01.17.
 */
public class LoginContainer {
    private String nick;
    private String respondQueue;

    public LoginContainer(String nick, String respondQueue) {
        this.nick = nick;
        this.respondQueue = respondQueue;
    }

    public LoginContainer(){}

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRespondQueue() {
        return respondQueue;
    }

    public void setRespondQueue(String respondQueue) {
        this.respondQueue = respondQueue;
    }
}
