package com.decathlon.katas.progfunc.poker;

/**
 * Rank of any card
 * @author deadbrain
 */
public enum Rank {
    ACE(new Tuple(1, 14)),
    TWO(new Tuple(2, 2)),
    THREE(new Tuple(3, 3)),
    FOUR(new Tuple(4, 4)),
    FIVE(new Tuple(5, 5)),
    SIX(new Tuple(6, 6)),
    SEVEN(new Tuple(7, 7)),
    EIGHT(new Tuple(8, 8)),
    NINE(new Tuple(9, 9)),
    TEN(new Tuple(10, 10)),
    JACK(new Tuple(11, 11)),
    QUEEN(new Tuple(12, 12)),
    KING(new Tuple(13, 13))
    ;

    private final Tuple tuple;

    Rank(Tuple tuple) {
        this.tuple = tuple;
    }

    public Tuple getTuple() {
        return tuple;
    }
}
