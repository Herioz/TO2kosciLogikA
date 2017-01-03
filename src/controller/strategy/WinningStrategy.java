package controller.strategy;

import model.GameState;
import model.Player;

import java.util.List;

/**
 * Created by Kamil on 2016-12-30.
 */
public interface WinningStrategy {
    List<Player> checkWinner(GameState gameState);
}
