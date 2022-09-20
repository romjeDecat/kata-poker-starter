package com.decathlon.katas.progfunc.poker;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static java.util.stream.Collectors.groupingBy;

/**
 * hand of cards (5)
 * use  this as you want, refactor it as often as needed
 * @author deadbrain
 */
public class Hand {
    private final List<Card> cards;

    public Hand(List<Card> cards) {
        if(cards.size() != 5) {
            throw new IllegalArgumentException("invalid cards passed to hand creation");
        }
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean hasNIdenticalCardsRank(int numberOfCards) {
        return getCardGroupedBy(Card::rank)
                .values()
                .stream()
                .anyMatch(cards -> cards.size() == numberOfCards);
    }

    public int howManyNIdenticalCardsRank(int numberOfCards) {
        return (int) getCardGroupedBy(Card::rank)
                .values()
                .stream()
                .filter(cards -> cards.size() == numberOfCards)
                .count();
    }

    public boolean hasNIdenticalColor(int numberOfCards) {
        return getCardGroupedBy(Card::color)
                .values()
                .stream()
                .anyMatch(cards -> cards.size() == numberOfCards);
    }

    private <T> Map<T, List<Card>> getCardGroupedBy(Function<Card, T> groupFunction) {
        return getCards()
                .stream()
                .collect(groupingBy(groupFunction));
    }

    public List<Card> sortByMinRank() {
        return sortBy(o -> o.rank().getTuple().min());
    }

    public List<Card> sortByMaxRank() {
        return sortBy(o -> o.rank().getTuple().max());
    }

    private List<Card> sortBy(ToIntFunction<Card> comparatorFunction) {
        return cards.stream().sorted(Comparator.comparingInt(comparatorFunction)).toList();
    }
}
