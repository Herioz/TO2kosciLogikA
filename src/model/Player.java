package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kamil on 2016-12-29.
 */
public class Player {
    private String name;
    private Integer points = 0;
    private List<Integer> dice = new LinkedList<>();



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


}
