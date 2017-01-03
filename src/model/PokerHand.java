package model;

import java.util.List;

/**
 * Created by Kamil on 2017-01-02.
 */
public class PokerHand implements  Comparable<PokerHand>{
    private PokerRank rank;
    private List<Integer> values;

    public PokerHand(PokerRank rank, List<Integer> values) {
        this.rank = rank;
        this.values = values;
    }


    @Override
    public int compareTo(PokerHand otherPokerHand) {
        if(otherPokerHand == null){
            return 1;
        }
        if( otherPokerHand.getRank().getRank() == this.getRank().getRank()){
            for (int i = 0 ; i<this.values.size(); i++) {
                int ret = this.values.get(i).compareTo(otherPokerHand.getValues().get(i)) ;
                if (ret !=0){
                    return ret;
                }
            }
        }else{
            return Integer.compare( this.getRank().getRank(), otherPokerHand.getRank().getRank());
        }

        return 0;
    }

    public PokerRank getRank() {
        return rank;
    }

    public List<Integer> getValues() {
        return values;
    }

}
