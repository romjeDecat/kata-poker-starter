package com.decathlon.katas.progfunc.poker;

import java.util.List;

/**
 * hand of cards (5)
 * use  this as you want, refactor it as often as needed
 * @author deadbrain
 */
public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
