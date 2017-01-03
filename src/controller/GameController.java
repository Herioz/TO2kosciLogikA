package controller;

import exception.OperationNotAllowedException;
import exception.MoveNotAllowedException;
import model.Game;
import model.GameState;
import model.Move;
import model.Player;

/**
 * Created by Kamil on 2016-12-29.
 */
public interface GameController {
    GameState addPlayer(Player player) throws OperationNotAllowedException;
    GameState makeMove(Player player, Move move) throws MoveNotAllowedException;
    GameState timeoutMeMutherFucker();
    Game getGame();
    GameState quitGame(Player player);

}
