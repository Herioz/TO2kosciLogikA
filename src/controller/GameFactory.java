package controller;

import controller.GameController;
import model.Configuration;
import model.Player;

import java.util.List;

/**
 * Created by Kamil on 2016-12-29.
 */
public interface GameFactory {
    GameController createGame(Configuration configuration, Player player, List<Player> bots);

}
