package com.decathlon.katas.progfunc.poker;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dealer {

    public boolean hasFullHouse(Hand hand) {
        return hasPair(hand) && hasThreeOfAKind(hand);
    }

    public boolean hasTwoPair(Hand hand) {
        return hand.howManyNIdenticalCardGroupBy(Card::getRank, 2) == 2;
    }

    public boolean hasPair(Hand hand) {
        return hand.howManyNIdenticalCardGroupBy(Card::getRank, 2) == 1;
    }

    public boolean hasThreeOfAKind(Hand hand) {
        return hand.howManyNIdenticalCardGroupBy(Card::getRank, 3) == 1;
    }

    public boolean hasFourOfAKind(Hand hand) {
        return hand.howManyNIdenticalCardGroupBy(Card::getRank, 4) == 1;
    }

    public boolean hasFlush(Hand hand) {
        return hand.howManyNIdenticalCardGroupBy(Card::getColor, 5) == 1;
    }

    public boolean hasStraight(Hand hand) {
        List<Integer> cardsByMinValues = sortCardByRankValue(hand, card -> card.getRank().getMin());
        List<Integer> cardsByMaxValues = sortCardByRankValue(hand, card -> card.getRank().getMax());
        return computeRankValueDiff(cardsByMinValues) == 4 || computeRankValueDiff(cardsByMaxValues) == 4;
    }

    private int computeRankValueDiff(List<Integer> cardRankValues) {
        return cardRankValues.get(cardRankValues.size() - 1) - cardRankValues.get(0);
    }

    private List<Integer> sortCardByRankValue(Hand hand, Function<Card, Integer> rankValueFunction) {
        return hand.getCards()
                .stream()
                .map(rankValueFunction)
                .sorted()
                .collect(Collectors.toList());
    }

}
