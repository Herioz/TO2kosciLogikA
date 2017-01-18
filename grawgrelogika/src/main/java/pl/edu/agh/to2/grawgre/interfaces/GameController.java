package pl.edu.agh.to2.grawgre.interfaces;

import pl.edu.agh.to2.grawgre.exception.MoveNotAllowedException;
import pl.edu.agh.to2.grawgre.exception.OperationNotAllowedException;
import pl.edu.agh.to2.grawgre.model.Game;
import pl.edu.agh.to2.grawgre.model.GameState;
import pl.edu.agh.to2.grawgre.model.Move;
import pl.edu.agh.to2.grawgre.model.Player;

/**
 * Created by luke on 06.01.17.
 */
public interface GameController {

    GameState addPlayer(Player player) throws OperationNotAllowedException;
    GameState makeMove(Player player, Move move) throws MoveNotAllowedException;
    GameState timeoutMeMutherFucker();
    Game getGame();
    GameState quitGame(Player player);

}
