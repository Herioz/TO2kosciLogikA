import controller.ConcreteGameFactory;
import controller.GameController;
import exception.OperationNotAllowedException;
import exception.MoveNotAllowedException;
import junit.framework.TestCase;
import model.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kamil on 2017-01-02.
 */
public class GameControllerTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private Player turekele;
    private Configuration conf;
    private GameController gc;
    private Player dejmien;




    @Before
    public void setup(){
        Configuration conf = new Configuration(GameType.POKER,1, Collections.emptyList(),3);
        ConcreteGameFactory factory = new ConcreteGameFactory();
        this.turekele = new Player();
        this.turekele.setName("turekelelele");
        this.dejmien = new Player();
        this.dejmien.setName("Wojciech Turek");


        this.gc = factory.createGame(conf,turekele,Collections.emptyList());
        try {
            this.gc.addPlayer(dejmien);
        } catch (OperationNotAllowedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AddSamePlayerTest() throws OperationNotAllowedException {
        TestCase.assertEquals(2,gc.getGame().getGameState().getListOfPlayers().size());

        exception.expect(OperationNotAllowedException.class);
        gc.addPlayer(dejmien);
    }
    @Test
    public void TooManyPlayersTest() throws OperationNotAllowedException {
        Player dejmien2 = new Player();
        dejmien2.setName("Wojciech Turek2");

        Player dejmien3 = new Player();
        dejmien3.setName("Wojciech Turek3");

        gc.addPlayer(dejmien2);
        exception.expect(OperationNotAllowedException.class);
        gc.addPlayer(dejmien3);

    }
    @Test
    public void AddPlayerStatusTest() throws OperationNotAllowedException {
        gc.getGame().getGameState().setGameStatus(GameStatus.STARTED);
        Player dejmien3 = new Player();
        dejmien3.setName("Wojciech Turek3");
        exception.expect(OperationNotAllowedException.class);
        gc.addPlayer(dejmien3);
    }

    @Test
    public void AddPlayerPositiveTest() throws OperationNotAllowedException {
        Player dejmien3 = new Player();
        dejmien3.setName("Wojciech Turek3");
        gc.addPlayer(dejmien3);
        TestCase.assertEquals(GameStatus.STARTED,gc.getGame().getGameState().getGameStatus());
        TestCase.assertEquals(turekele.getName(),  gc.getGame().getGameState().getActivePlayer());

    }


    @Test
    public void quitGameTest(){
        gc.getGame().getGameState().setGameStatus(GameStatus.STARTED);
        gc.quitGame(this.dejmien);
        TestCase.assertEquals(GameStatus.STOPPED, gc.getGame().getGameState().getGameStatus());
        TestCase.assertEquals(1, gc.getGame().getGameState().getListOfPlayers().size());
    }
    @Test
    public void timeoutMeTest(){
        gc.getGame().getGameState().setGameStatus(GameStatus.STARTED);
        gc.timeoutMeMutherFucker();
        TestCase.assertEquals(dejmien.getName(),gc.getGame().getGameState().getActivePlayer());

        gc.timeoutMeMutherFucker();
        TestCase.assertEquals(turekele.getName(),gc.getGame().getGameState().getActivePlayer());

    }
    private int dejmienCount =1;
    private void addDejmien() throws OperationNotAllowedException {
        Player dejmien = new Player();
        this.dejmienCount ++;
        dejmien.setName("Wojciech Turek"+dejmienCount);
        gc.addPlayer(dejmien);
    }

    @Test
    public void moveNotStartedTest() throws MoveNotAllowedException, OperationNotAllowedException {
        Set<Integer> dice  = new HashSet<>(Arrays.asList(1,2,3,4,5));

        exception.expect(MoveNotAllowedException.class);
        gc.makeMove(this.dejmien,new Move(dice));
    }


    @Test
    public void moveIllegalPlayerTest() throws MoveNotAllowedException, OperationNotAllowedException {
        this.addDejmien();
        Set<Integer> dice  = new HashSet<>(Arrays.asList(1,2,3,4,5));

        exception.expect(MoveNotAllowedException.class);
        gc.makeMove(this.dejmien,new Move(dice));
    }

    @Test
    public void moveTooManyThrowsTest() throws MoveNotAllowedException, OperationNotAllowedException {
        this.addDejmien();
        Set<Integer> dice  = new HashSet<>(Arrays.asList(1,2,3,4,5));


        gc.makeMove(this.turekele,new Move(dice));
        gc.makeMove(this.turekele,new Move(dice));
        gc.makeMove(this.turekele,new Move(dice));
        exception.expect(MoveNotAllowedException.class);
        gc.makeMove(this.turekele,new Move(dice));



    }
    @Test
    public void moveTest() throws OperationNotAllowedException, MoveNotAllowedException {
        this.addDejmien();
        Set<Integer> dice  = new HashSet<>(Arrays.asList(1,2,3,4,5));

        this.gc.makeMove(this.turekele,new Move(dice));
        this.gc.makeMove(this.turekele,new Move(dice));
        assertThat( turekele.getDice() ,is(Arrays.asList(1,2,3,4,5)));
        gc.timeoutMeMutherFucker();

        gc.timeoutMeMutherFucker();
        GameState gs = gc.timeoutMeMutherFucker();
        TestCase.assertTrue( turekele.getName().equals(gc.getGame().getGameState().getActivePlayer()));
        TestCase.assertEquals(GameStatus.STOPPED,gs.getGameStatus());
        TestCase.assertEquals(1,gs.getListOfPlayers().get(0).getPoints().intValue());
        TestCase.assertEquals(0,gs.getListOfPlayers().get(1).getPoints().intValue());
        TestCase.assertEquals(0,gs.getListOfPlayers().get(2).getPoints().intValue());
    }
}
