package com.decathlon.katas.progfunc.poker;

import java.util.List;
import java.util.Objects;

/**
 * hand of cards (5)
 * use  this as you want, refactor it as often as needed
 *
 * @author deadbrain
 */
public record Hand(List<Card> cards) {

    public Hand(List<Card> cards) {
        Objects.requireNonNull(cards);
        if (cards.size() != 5)
            throw new IllegalArgumentException("Hand should have 5 cards");
        this.cards = List.copyOf(cards);
    }
}
