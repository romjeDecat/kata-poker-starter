package com.decathlon.katas.progfunc.poker;

/**
 * Rank of any card
 *
 * @author deadbrain
 */
public enum Rank {
    ACE(1, 14),
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    private final int min;
    private final int max;

    Rank() {
        this.min = ordinal() + 1;
        this.max = ordinal() + 1;
    }

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
