package controller;

import controller.strategy.WinningStrategy;
import exception.OperationNotAllowedException;
import exception.MoveNotAllowedException;
import model.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class ConcreteGameController implements GameController {


    private Game game;
    private Configuration configuration;
    private int throwNumber = 0;
    private int activeIndex = 0;
    private WinningStrategy winningStrategy;




    public ConcreteGameController(Game game, Configuration configuration, WinningStrategy ws) {
        this.game = game;
        this.configuration = configuration;
        this.winningStrategy =ws;
        randomTarget();
    }

    @Override
    public GameState addPlayer(Player player) throws OperationNotAllowedException {
        if (this.game.getGameState().getGameStatus()!= GameStatus.LOBBY){
            throw new OperationNotAllowedException();
        }

        GameState gs= this.game.getGameState();
        if (this.game.getPlacesLeft() >0) {
            if (gs.getListOfPlayers().stream().anyMatch(player1 -> player1.getName().equals(player.getName()))){
                throw new OperationNotAllowedException();
            }
            gs.getListOfPlayers().add(player);
            this.game.setPlacesLeft(this.game.getPlacesLeft() -1);
        }else{
            throw new OperationNotAllowedException();
        }

        //auto start
        if (this.game.getPlacesLeft() == 0){
            gs.setActivePlayer(gs.getListOfPlayers().get(0).getName());
            gs.setGameStatus(GameStatus.STARTED);
        }

        return gs;

    }

    @Override
    public GameState makeMove(Player player, Move move) throws MoveNotAllowedException {
        GameState gs = this.game.getGameState();
        if( gs.getGameStatus()!=GameStatus.STARTED ) {
            throw new MoveNotAllowedException();
        }

        if( gs.getActivePlayer().compareTo(player.getName()) != 0){
            throw new MoveNotAllowedException();
        }
        if( this.throwNumber > 2){
            throw new MoveNotAllowedException();
        }

        //making move
        String playerName = gs.getActivePlayer();

        Player p = gs.getListOfPlayers().stream().filter(player1 -> player1.getName().equals(playerName)).findFirst().get();

        if(p.getDice().isEmpty()){
            for ( int i=0; i < 5 ; i++) {
                p.getDice().add(ThreadLocalRandom.current().nextInt(1, 7));
                //wrocic do randoma
            }
        }else{
            for (Integer i : move.getDice()) {
                p.getDice().set(i-1,ThreadLocalRandom.current().nextInt(1,7));
                //wrocic do randoma
            }
        }

        this.throwNumber++;
        //last move
        if ( this.throwNumber == 3){
            endTurn();

        }

        return gs;
    }

    private void endTurn(){
        GameState gs = this.game.getGameState();
        this.throwNumber=0;
        activeIndex++;
        activeIndex%= gs.getListOfPlayers().size();
        if (activeIndex == 0){   //last move in round
            List<Player> winnerList = winningStrategy.checkWinner(this.game.getGameState());
            randomTarget();
            for( Player p : winnerList){
                p.setPoints(p.getPoints()+1);
                if (p.getPoints() == configuration.getNumberOfPointsToWin()){
                    game.getGameState().setGameStatus(GameStatus.STOPPED);
                }
            }

            gs.getListOfPlayers().stream().forEach( player -> player.getDice().clear());
        }
        gs.setActivePlayer(gs.getListOfPlayers().get(activeIndex).getName());

    }
    @Override
    public GameState timeoutMeMutherFucker() {
        if(this.game.getGameState().getGameStatus() != GameStatus.STARTED){
            return this.game.getGameState();
        }
        endTurn();
        return this.game.getGameState();
    }

    @Override
    public Game getGame() {
        return this.game;
    }

    @Override
    public GameState quitGame(Player player) {
        GameState gs = this.game.getGameState();
        gs.getListOfPlayers().remove(player);
        if(gs.getGameStatus() ==GameStatus.STARTED) {
            gs.setGameStatus(GameStatus.STOPPED);
        }
        return gs;
    }

    private void randomTarget(){
        if (configuration.getGameType() == GameType.N_STAR){
            this.game.getGameState().setWinningNumber(ThreadLocalRandom.current().nextInt(5,3500));
        }else if (configuration.getGameType() == GameType.N_PLUS){
            this.game.getGameState().setWinningNumber(ThreadLocalRandom.current().nextInt(1,30));
        }

    }

}
