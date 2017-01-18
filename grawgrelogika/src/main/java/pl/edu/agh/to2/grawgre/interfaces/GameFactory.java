package pl.edu.agh.to2.grawgre.interfaces;

import pl.edu.agh.to2.grawgre.model.Configuration;
import pl.edu.agh.to2.grawgre.model.Player;

import java.util.List;

/**
 * Created by luke on 06.01.17.
 */
public interface GameFactory {

    GameController createGame(Configuration configuration, Player player, List<Player> bots);

}
