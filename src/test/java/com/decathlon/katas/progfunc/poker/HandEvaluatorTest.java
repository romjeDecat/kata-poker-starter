package com.decathlon.katas.progfunc.poker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.decathlon.katas.progfunc.poker.Color.*;
import static com.decathlon.katas.progfunc.poker.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HandEvaluatorTest {

    private HandEvaluator cut;

    @BeforeEach
    void setup() {
        cut = new HandEvaluator();
    }

    @Test
    void a_hand_with_two_cards_of_same_rank_is_a_pair() {
        //Given
        Hand hand = aPair();
        //Then
        boolean expected = cut.isPair(hand);
        //
        assertThat(expected).isTrue();
    }

    @Test
    void a_hand_with_three_cards_of_same_rank_is_a_three_of_a_kind() {
        //Given
        Hand hand = aThreeOfAKind();
        //Then
        boolean expected = cut.isThreeOfAKind(hand);
        //
        assertThat(expected).isTrue();
    }

    @Test
    void a_hand_with_four_cards_of_same_rank_is_a_four_of_a_kind() {
        //Given
        Hand hand = aFourOfAKind();
        //Then
        boolean expected = cut.isFourOfAKind(hand);
        //
        assertThat(expected).isTrue();
    }

    @Test
    void a_pair_is_not_a_three_of_kind() {
        //Given
        Hand hand = aPair();
        //When
        boolean pair = cut.isPair(hand);
        boolean threeOfAKind = cut.isThreeOfAKind(hand);
        //Then
        assertThat(pair).isTrue();
        assertThat(threeOfAKind).isFalse();
    }

    @Test
    void a_hand_with_two_pairs_is_not_a_pair() {
        //Given
        Hand hand = twoPairs();
        //When
        boolean expected = cut.isPair(hand);
        //Then
        assertThat(expected).isFalse();
    }

    @Test
    void a_hand_with_two_pairs_is_a_double_pair() {
        //Given
        Hand hand = twoPairs();
        //When
        boolean expected = cut.isDoublePair(hand);
        //Then
        assertThat(expected).isTrue();
    }

    @Test
    void a_hand_with_a_pair_and_a_three_of_kind_is_a_full_house() {
        //Given
        Hand hand = aFullHouse();
        //When
        boolean expected = cut.isFullHouse(hand);
        //Then
        assertThat(expected).isTrue();
    }

    @Test
    void a_hand_with_five_cards_of_same_color_is_a_flush() {
        //Given
        Hand flushHand = aFlush();
        //When
        boolean expected = cut.hasFlush(flushHand);
        //Then
        assertThat(expected).isTrue();
    }

    @Test
    void a_hand_with_four_cards_of_same_color_is_not_a_flush() {
        //Given
        Hand flushHand = fourCardsOfSameColor();
        //When
        boolean expected = cut.hasFlush(flushHand);
        //Then
        assertThat(expected).isFalse();
    }

    @Test
    void a_hand_with_five_consecutive_ranks_is_a_straight() {
        //Given
        Hand straightHand = aStraight();
        //When
        boolean expected = cut.isStraight(straightHand);
        //Then
        assertThat(expected).isTrue();
    }

    @Test
    void verify_a_straight_with_ace_as_min() {
        //Given
        Hand straightHand = aStraightMin();
        //When
        boolean expected = cut.isStraight(straightHand);
        //Then
        assertThat(expected).isTrue();
    }

    @Test
    void verify_a_straight_with_ace_as_max() {
        //Given
        Hand straightHand = aStraightMax();
        //When
        boolean expected = cut.isStraight(straightHand);
        //Then
        assertThat(expected).isTrue();
    }

    @Test
    void minRankCardBy_returns_the_card_with_the_minimal_value() {
        //Given
        Hand aStraight = aStraight();
        //When
        Rank rank = cut.minRankCardBy(aStraight, Rank::getMin);
        //Then
        assertThat(rank).isEqualTo(SEVEN);
    }

    @Test
    void maxRankCardBy_returns_the_card_with_the_maximum_value() {
        //Given
        Hand aStraight = aStraight();
        //When
        Rank rank = cut.maxRankCardBy(aStraight, Rank::getMax);
        //Then
        assertThat(rank).isEqualTo(JACK);
    }

    private static Hand aPair() {
        return new Hand(List.of(
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(SIX, SPADE),
                new Card(THREE, SPADE),
                new Card(FOUR, SPADE)
        ));
    }

    private static Hand twoPairs() {
        return new Hand(List.of(
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(SIX, SPADE),
                new Card(SIX, SPADE),
                new Card(FOUR, SPADE)
        ));
    }

    private static Hand aThreeOfAKind() {
        return new Hand(List.of(
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(THREE, SPADE),
                new Card(FOUR, SPADE)
        ));
    }

    private static Hand aFourOfAKind() {
        return new Hand(List.of(
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(FOUR, SPADE)
        ));
    }

    private static Hand aFullHouse() {
        return new Hand(List.of(
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(FIVE, SPADE),
                new Card(THREE, SPADE),
                new Card(THREE, SPADE)
        ));
    }

    private static Hand aFlush() {
        return new Hand(List.of(
                new Card(SEVEN, TREFLE),
                new Card(EIGHT, TREFLE),
                new Card(NINE, TREFLE),
                new Card(TEN, TREFLE),
                new Card(JACK, TREFLE)
        ));
    }

    private static Hand fourCardsOfSameColor() {
        return new Hand(List.of(
                new Card(SEVEN, SPADE),
                new Card(EIGHT, TREFLE),
                new Card(NINE, TREFLE),
                new Card(TEN, TREFLE),
                new Card(JACK, TREFLE)
        ));
    }

    private static Hand aStraight() {
        return new Hand(List.of(
                new Card(SEVEN, TREFLE),
                new Card(EIGHT, DIAMOND),
                new Card(NINE, SPADE),
                new Card(TEN, TREFLE),
                new Card(JACK, HEART)
        ));
    }

    private static Hand aStraightMax() {
        return new Hand(List.of(
                new Card(TEN, TREFLE),
                new Card(JACK, DIAMOND),
                new Card(QUEEN, SPADE),
                new Card(KING, TREFLE),
                new Card(ACE, HEART)
        ));
    }

    private static Hand aStraightMin() {
        return new Hand(List.of(
                new Card(ACE, TREFLE),
                new Card(TWO, DIAMOND),
                new Card(THREE, SPADE),
                new Card(FOUR, TREFLE),
                new Card(FIVE, HEART)
        ));
    }


}