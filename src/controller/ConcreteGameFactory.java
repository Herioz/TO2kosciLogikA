package controller;

import controller.strategy.NWinningStrategy;
import controller.strategy.PokerWinningStrategy;
import controller.strategy.WinningStrategy;
import exception.OperationNotAllowedException;
import model.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kamil on 2016-12-29.
 */
public class ConcreteGameFactory implements AbstractGameFactory {
    private int ID = 1;
    @Override
    public GameController createGame(Configuration configuration, Player player, List<Player> bots) {
        LinkedList<Player> pl = new LinkedList<Player>();
        pl.add(player);
        GameState gs = new GameState(pl, GameStatus.LOBBY,configuration.getNumberOfPointsToWin());
        Game game = new Game(this.ID,configuration.getGameType(),configuration.getHumansNum()-1,gs);
        this.ID++;

        WinningStrategy ws = null;

        // BOTY I INNE ZABAWKI XD MAJaczysz XD
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
