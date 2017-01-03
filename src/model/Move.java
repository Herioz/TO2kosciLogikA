package model;

import java.util.Set;

/**
 * Created by Kamil on 2016-12-29.
 */
public class Move {
    private Set<Integer> dice;

    public Move(Set<Integer> dice) {
        this.dice = dice;
    }

    public Set<Integer> getDice() {
        return dice;
    }

    public void setDice(Set<Integer> dice) {
        this.dice = dice;
    }
}
