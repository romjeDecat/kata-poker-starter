package com.decathlon.katas.progfunc.poker;

import java.util.Comparator;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class HandEvaluator {

    public boolean isPair(Hand hand) {
        return hasOnlyOneRankWithExactCount(hand, 2L);
    }

    public boolean isThreeOfAKind(Hand hand) {
        return hasOnlyOneRankWithExactCount(hand, 3);
    }

    public boolean isFourOfAKind(Hand hand) {
        return hasOnlyOneRankWithExactCount(hand, 4L);
    }

    private boolean hasOnlyOneRankWithExactCount(Hand hand, long value) {
        return computeRank(hand, value) == 1;
    }

    private long computeRank(Hand hand, long value) {
        return countByRank(hand)
                .values().stream()
                .filter(l -> l == value)
                .count();
    }

    private Map<Rank, Long> countByRank(Hand hand) {
        return hand.cards().stream()
                .collect(Collectors.groupingBy(Card::rank, Collectors.counting()));
    }

    public boolean isFullHouse(Hand hand) {
        return isThreeOfAKind(hand) && isPair(hand);
    }

    public boolean isDoublePair(Hand hand) {
        return countByRank(hand).values()
                .stream()
                .filter(l -> l == 2)
                .count() == 2;
    }

    public boolean hasFlush(Hand flush) {
        //All cards of the same color
        return flush.cards().stream()
                .collect(Collectors.groupingBy(Card::color))
                .size() == 1;
    }

    public boolean isStraight(Hand hand) {
        return isStraightBy(hand, Rank::getMin) || isStraightBy(hand, Rank::getMax);
    }

    private boolean isStraightBy(Hand hand, ToIntFunction<Rank> comparison) {
        Rank minRank = minRankCardBy(hand, comparison);
        Rank maxRank = maxRankCardBy(hand, comparison);
        return maxRank.getMax() - minRank.getMin() == 4;
    }

    public Rank minRankCardBy(Hand hand, ToIntFunction<Rank> comparison) {
        return hand.cards().stream()
                .map(Card::rank)
                .min(Comparator.comparingInt(comparison))
                .orElse(null);
    }

    public Rank maxRankCardBy(Hand hand, ToIntFunction<Rank> comparison) {
        return hand.cards().stream()
                .map(Card::rank)
                .max(Comparator.comparingInt(comparison))
                .orElse(null);
    }
}
