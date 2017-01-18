package pl.edu.agh.to2.grawgre.logic;


import pl.edu.agh.to2.grawgre.exception.OperationNotAllowedException;
import pl.edu.agh.to2.grawgre.interfaces.GameController;
import pl.edu.agh.to2.grawgre.interfaces.GameFactory;
import pl.edu.agh.to2.grawgre.logic.strategy.NWinningStrategy;
import pl.edu.agh.to2.grawgre.logic.strategy.PokerWinningStrategy;
import pl.edu.agh.to2.grawgre.logic.strategy.WinningStrategy;
import pl.edu.agh.to2.grawgre.model.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kamil on 2016-12-29.
 */
public class ConcreteGameFactory implements GameFactory {
    private int ID = 1;
    @Override
    public GameController createGame(Configuration configuration, Player player, List<Player> bots) {
        LinkedList<Player> pl = new LinkedList<Player>();
        pl.add(player);
        GameState gs = new GameState(pl, GameStatus.LOBBY,player.getName());
        gs.setNumberOfPointsToWin(configuration.getNumberOfPointsToWin());
        Game game = new Game(this.ID,configuration.getGameType(),configuration.getHumansNum()-1,gs);
        this.ID++;

        WinningStrategy ws = null;


        switch (configuration.getGameType()){
            case N_PLUS:
                ws= new NWinningStrategy((a, b) -> a+b , 0);
                break;
            case N_STAR:
                ws = new NWinningStrategy((a, b)->a*b, 1);
                break;
            case POKER:
                ws = new PokerWinningStrategy();
                break;
        }
        ConcreteGameController gc =new ConcreteGameController(game,configuration,ws);
        bots.stream().forEach(bot -> {
            try {
                gc.addPlayer(bot);
            } catch (OperationNotAllowedException e) {
                e.printStackTrace();
            }
        });

        return gc;


    }
}
