package com.decathlon.katas.progfunc.poker;

/**
 * a card contains references to a rank & color
 */
public class Card {
    private Rank rank;
    private Color color;

    public Card(Rank rank, Color color) {
        this.rank = rank;
        this.color = color;
    }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }
}
