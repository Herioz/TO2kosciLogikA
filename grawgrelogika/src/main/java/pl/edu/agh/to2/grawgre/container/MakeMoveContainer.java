package pl.edu.agh.to2.grawgre.container;

import pl.edu.agh.to2.grawgre.model.Move;

import java.io.Serializable;

/**
 * Created by pawel on 05.01.17.
 */
public class MakeMoveContainer {
    private String nick;
    private Move move;

    public MakeMoveContainer(String nick, Move move) {
        this.nick = nick;
        this.move = move;
    }

    public MakeMoveContainer(){}

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
