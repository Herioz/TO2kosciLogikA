package model;

/**
 * Created by Kamil on 2016-12-30.
 */
public enum PokerRank implements Comparable<PokerRank> {
    FIVE(8),FOUR(7),FULL(6),STRAIGHT_BIG(5),STRAIGHT_SMALL(4),THREE(3),TWOPAIRS(2),ONEPAIR(1),BUST(0);

    private final int rank;



    private PokerRank(int i) {
        this.rank = i;
    }

    public int getRank() {
        return rank;
    }

}
