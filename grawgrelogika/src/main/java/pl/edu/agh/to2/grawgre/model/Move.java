package pl.edu.agh.to2.grawgre.model;

import java.util.Set;

/**
 * Created by pawel on 05.01.17.
 */
public class Move {
    private Set<Integer> dice;

    public Set<Integer> getDice() {
        return dice;
    }

    public void setDice(Set<Integer> dice) {
        this.dice = dice;
    }

    public Move(Set<Integer> dice) {
        this.dice = dice;
    }

    public Move(){}
}
