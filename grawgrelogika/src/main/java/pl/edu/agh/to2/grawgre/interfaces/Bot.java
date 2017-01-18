package pl.edu.agh.to2.grawgre.interfaces;

import pl.edu.agh.to2.grawgre.model.GameState;
import pl.edu.agh.to2.grawgre.model.Move;

/**
 * Created by luke on 06.01.17.
 */
public abstract class Bot {

    private String nick;

    public abstract Move makeMove(GameState gameState);

    public String getNick(){
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
