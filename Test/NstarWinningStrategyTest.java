import controller.strategy.NWinningStrategy;
import model.GameState;
import model.GameStatus;
import model.Player;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


/**
 * Created by Kamil on 2017-01-02.
 */
public class NstarWinningStrategyTest {
    private NWinningStrategy nws = new NWinningStrategy( (a, b)-> a*b  ,1);

    @Test
    public void testCheckWinner(){
        Player wojtek = new Player();
        Player Turek = new Player();
        Player trzeciGracz = new Player();
        trzeciGracz.setName("trzeci");
        trzeciGracz.setDice(Arrays.asList(1,1,5,5,5));
        Turek.setDice(Arrays.asList(1,1,5,6,5));
        Turek.setName("turek");
        wojtek.setDice(Arrays.asList(1,2,2,5,5));
        wojtek.setName("wojtek");
        List<Player> players  = Arrays.asList(Turek,trzeciGracz,wojtek);
        GameState gs = new GameState(players, GameStatus.STARTED,3);
        gs.setActivePlayer(wojtek.getName());
        gs.setWinningNumber(150);

        List<Player> winners = nws.checkWinner(gs);
        assertEquals("turek",winners.get(0).getName());
    }

}
