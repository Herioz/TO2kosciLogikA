package pl.edu.agh.to2.grawgre.logic.strategy;

import pl.edu.agh.to2.grawgre.model.GameState;
import pl.edu.agh.to2.grawgre.model.Player;

import java.util.List;

/**
 * Created by Kamil on 2016-12-30.
 */
public interface WinningStrategy {
    List<Player> checkWinner(GameState gameState);
}
