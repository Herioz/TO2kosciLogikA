package pl.edu.agh.to2.grawgre.model;

import java.util.List;

/**
 * Created by pawel on 05.01.17.
 */
public class Player {
    private String name;
    private Integer points;
    private List<Integer> dice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public List<Integer> getDice() {
        return dice;
    }

    public void setDice(List<Integer> dice) {
        this.dice = dice;
    }

    public Player(String name, Integer points, List<Integer> dice) {
        this.name = name;
        this.points = points;
        this.dice = dice;
    }

    public Player(){}
}
