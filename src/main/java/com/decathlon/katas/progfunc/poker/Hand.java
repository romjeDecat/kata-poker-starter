package com.decathlon.katas.progfunc.poker;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

/**
 * hand of cards (5)
 * use  this as you want, refactor it as often as needed
 * @author deadbrain
 */
public class Hand {
    private final List<Card> cards;

    public Hand(List<Card> cards) {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("A hand must contains 5 cards when you provided " + cards.size() + " cards");
        }
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public long howManyNIdenticalCardGroupBy(Function<Card, ?> groupBy, int expectedNumberOfCard) {
        return this.getCards()
                .stream()
                .map(groupBy)
                .collect(groupingBy(identity(), counting()))
                .values()
                .stream()
                .filter(numberOfCard -> numberOfCard == expectedNumberOfCard)
                .count();
    }
}
