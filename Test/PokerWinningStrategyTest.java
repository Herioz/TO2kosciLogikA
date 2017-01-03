import controller.strategy.PokerWinningStrategy;
import model.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Kamil on 2017-01-02.
 */
public class PokerWinningStrategyTest {
    PokerWinningStrategy pws = new PokerWinningStrategy();
    Player dummy = new Player();

    @org.junit.Test
    public void checkWinner() throws Exception {
        Player wojtek = new Player();
        Player Turek = new Player();
        Player trzeciGracz = new Player();
        trzeciGracz.setName("trzeci");
        trzeciGracz.setDice(Arrays.asList(4,4,1,1,3));
        Turek.setDice(Arrays.asList(1,1,4,4,5));
        Turek.setName("turek");
        wojtek.setDice(Arrays.asList(1,4,1,2,4));
        wojtek.setName("wojtek");
        List<Player> players  = Arrays.asList(Turek,trzeciGracz,wojtek);
        GameState gs = new GameState(players, GameStatus.STARTED,3);
        gs.setActivePlayer(wojtek.getName());

        List<Player> winners = pws.checkWinner(gs);
        assertEquals("turek",winners.get(0).getName());
        assertThat(Arrays.asList(1,1,4,4,5),is(winners.get(0).getDice()));





    }

    @Test
    public void testCalculateHand(){
        dummy.setName("DumMy");
        dummy.setDice(Arrays.asList(5,4,6,2,4));
        PokerHand ph = pws.calculateHand(dummy.getDice());
        List<Integer> expected = Arrays.asList(4,6,5,2);

        assertEquals(PokerRank.ONEPAIR,ph.getRank());
        assertThat(ph.getValues(), is(expected));

    }


    @Test
    public void testFill()throws Exception{
        int[] sS = {1,1,1,1,1,1};

        List<Integer> actual = new LinkedList<>();
            List<Integer> expected = Arrays.asList(6,5,4,3,2,1);

        pws.fill(actual,sS);
        assertThat(actual, is(expected));


    }
}