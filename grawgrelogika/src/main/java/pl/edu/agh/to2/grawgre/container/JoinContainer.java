package pl.edu.agh.to2.grawgre.container;

import java.io.Serializable;

/**
 * Created by pawel on 05.01.17.
 */
public class JoinContainer {
    private String nick;
    private Integer gameID;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public JoinContainer(String nick, Integer gameID) {

        this.nick = nick;
        this.gameID = gameID;
    }

    public JoinContainer(){}
}
