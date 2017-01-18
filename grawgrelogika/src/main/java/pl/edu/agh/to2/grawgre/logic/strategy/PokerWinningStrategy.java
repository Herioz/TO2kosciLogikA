package pl.edu.agh.to2.grawgre.logic.strategy;


import pl.edu.agh.to2.grawgre.model.GameState;
import pl.edu.agh.to2.grawgre.model.Player;
import pl.edu.agh.to2.grawgre.model.PokerHand;
import pl.edu.agh.to2.grawgre.model.PokerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kamil on 2016-12-30.
 */
public class PokerWinningStrategy implements WinningStrategy {



    @Override
    public List<Player> checkWinner(GameState gameState) {


        //        Map<model.Player,model.PokerHand> playersHands = gameState.getListOfPlayers().stream().collect(
        //                Collectors.toMap(player->player, player->this.calculateHand(player) )
        //        );
//        if( !players.get(0).getDice().isEmpty()) {
//            winners.add(players.get(0));
//            bestHand = calculateHand(players.get(0));
//        }
//        for(int i =1; i< players.size() ; i++){
//            if(players.get(i).getDice().isEmpty()) continue;
//            model.PokerHand hand = calculateHand(players.get(i));
//            if ( hand.compareTo(bestHand)>0) {
//                winners.clear();
//                winners.add(players.get(i));
//                bestHand = hand;
//            }else if ( hand.compareTo(bestHand) ==0) {
//                winners.add(players.get(i));
//            }
//
//        }
//
//
        PokerHand bestHand = null;
        List<Player> winners =new LinkedList<>();
        for(Player p: gameState.getListOfPlayers()){
            if(p.getDice().isEmpty())continue;
            PokerHand hand = calculateHand(p.getDice());
            if ( hand.compareTo(bestHand)>0) {
                winners.clear();
                winners.add(p);
                bestHand = hand;
            }else if ( hand.compareTo(bestHand) ==  0) {
                winners.add(p);
            }

        }
        return winners;
    }




    public PokerHand calculateHand( List<Integer> dice) {

        int[] count = new int[6];
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < dice.size(); i++) {
            count[dice.get(i)-1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (count[i] == 5) {
                values.add(i+1);
                return new PokerHand(PokerRank.FIVE, values);
            } else if (count[i] == 4) {
                values.add(i+1);
                this.fill(values, count);
                return new PokerHand(PokerRank.FOUR, values);
            } else if (count[i] == 3) {
                values.add(i+1);
                for (int j = i+1; j < count.length; j++) {
                    if (count[j] == 2) {
                        values.add(j+1);
                        return new PokerHand(PokerRank.FULL, values);
                    }
                }

                fill(values, count);
                return new PokerHand(PokerRank.THREE, values);

            } else if (count[i] == 2) {

                for (int j = i+1; j < count.length; j++) {
                    if (j == i) continue;
                    if (count[j] == 3) {
                        values.add(j+1);
                        values.add(i+1);
                        return new PokerHand(PokerRank.FULL, values);
                    }
                    if (count[j] == 2) {
                        values.add(j+1);
                        values.add(i+1);
                        fill(values,count);
                        return new PokerHand(PokerRank.TWOPAIRS, values );
                    }
                }
                values.add(i+1);
                fill(values,count);
                return new PokerHand(PokerRank.ONEPAIR, values);
            }
        }
        if (count[0] == 0) {
            return new PokerHand(PokerRank.STRAIGHT_BIG, Collections.EMPTY_LIST);
        } else if (count[5] == 0) {
            return new PokerHand(PokerRank.STRAIGHT_SMALL, Collections.EMPTY_LIST);
        } else {
            fill(values,count);
            return new PokerHand(PokerRank.BUST,values);
        }
    }

    public void fill(List<Integer> values, int[] count) {
        for ( int j =count.length-1 ; j>=0 ; j--){
            if ( count[j] == 1){
                values.add(j+1);
            }
        }
    }


}
