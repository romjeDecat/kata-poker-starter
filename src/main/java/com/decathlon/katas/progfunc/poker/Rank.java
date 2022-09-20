package com.decathlon.katas.progfunc.poker;

/**
 * Rank of any card
 * @author deadbrain
 */
public enum Rank {
    ACE(1, 14),
    TWO(2, 2),
    THREE(3, 3),
    FOUR(4, 4),
    FIVE(5, 5),
    SIX(6, 6),
    SEVEN(7, 7),
    EIGHT(8, 8),
    NINE(9, 9),
    TEN(10, 10),
    JACK(11, 11),
    QUEEN(12, 12),
    KING(13, 13);

    private int min;

    private int max;

    Rank(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
