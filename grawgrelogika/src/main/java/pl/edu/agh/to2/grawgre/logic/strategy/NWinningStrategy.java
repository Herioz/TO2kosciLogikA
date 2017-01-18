package pl.edu.agh.to2.grawgre.logic.strategy;


import pl.edu.agh.to2.grawgre.model.GameState;
import pl.edu.agh.to2.grawgre.model.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Created by Kamil on 2016-12-30.
 */
public class NWinningStrategy implements WinningStrategy {
    BinaryOperator<Integer> operation;
    Integer identity;

    public NWinningStrategy(BinaryOperator<Integer> operation, Integer identity) {
        this.operation = operation;
        this.identity = identity;
    }

    @Override
    public List<Player> checkWinner(GameState gameState) {

        List<Player> closestPlayers = new LinkedList<>();
        int closest  =  Integer.MAX_VALUE;

        for(Player p: gameState.getListOfPlayers()){
            if(p.getDice().isEmpty()) continue;
            int roundPoints = p.getDice().stream().reduce(this.identity,this.operation);
            roundPoints = Math.abs(roundPoints-gameState.getWinningNumber());
            if (roundPoints < closest){
                closest =roundPoints;
                closestPlayers.clear();
                closestPlayers.add(p);
            }
            if (roundPoints == closest){
                closestPlayers.add(p);
            }
        }

        return closestPlayers;


    }
}
