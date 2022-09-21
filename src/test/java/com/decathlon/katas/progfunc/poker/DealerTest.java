package com.decathlon.katas.progfunc.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DealerTest {

    @Test
    void five_consecutive_card_is_a_straight() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasStraight = dealer.hasStraight(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.EIGHT, Color.TREFLE),
                new Card(Rank.NINE, Color.TREFLE),
                new Card(Rank.TEN, Color.TREFLE),
                new Card(Rank.JACK, Color.TREFLE)
        )));

        // then
        assertTrue(hasStraight);
    }

    @Test
    void five_consecutive_card_with_ace_as_first_card_is_a_straight() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasStraight = dealer.hasStraight(new Hand(List.of(
                new Card(Rank.ACE, Color.TREFLE),
                new Card(Rank.TWO, Color.TREFLE),
                new Card(Rank.THREE, Color.TREFLE),
                new Card(Rank.FOUR, Color.TREFLE),
                new Card(Rank.FIVE, Color.TREFLE)
        )));

        // then
        assertTrue(hasStraight);
    }

    @Test
    void five_consecutive_card_with_ace_as_last_card_is_a_suite() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasSuite = dealer.hasStraight(new Hand(List.of(
                new Card(Rank.TEN, Color.TREFLE),
                new Card(Rank.JACK, Color.TREFLE),
                new Card(Rank.QUEEN, Color.TREFLE),
                new Card(Rank.KING, Color.TREFLE),
                new Card(Rank.ACE, Color.TREFLE)
        )));

        // then
        assertTrue(hasSuite);
    }

    @Test
    void hand_with_five_card_same_color_is_a_flush() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasFlush = dealer.hasFlush(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.QUEEN, Color.TREFLE),
                new Card(Rank.JACK, Color.TREFLE),
                new Card(Rank.EIGHT, Color.TREFLE),
                new Card(Rank.SIX, Color.TREFLE)
        )));

        // then
        assertTrue(hasFlush);
    }

    @Test
    void hand_with_a_pair_of_four_and_seven_is_two_pairs() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasTwoPair = dealer.hasTwoPair(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.HEART),
                new Card(Rank.JACK, Color.SPADE),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.FOUR, Color.HEART)
        )));

        // then
        assertTrue(hasTwoPair);
    }

    @Test
    void hand_with_three_seven_and_two_four_is_a_full_house() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasFullHouse = dealer.hasFullHouse(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.HEART),
                new Card(Rank.SEVEN, Color.SPADE),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.FOUR, Color.HEART)
        )));

        // then
        assertTrue(hasFullHouse);
    }

    @Test
    void hand_with_two_seven_and_two_four_is_not_a_full_house() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasFullHouse = dealer.hasFullHouse(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.HEART),
                new Card(Rank.FOUR, Color.SPADE),
                new Card(Rank.QUEEN, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        )));

        // then
        assertFalse(hasFullHouse);
    }

    @Test
    void hand_with_four_seven_is_a_four_of_a_kind() {
        // given
        Dealer dealer = new Dealer();

        // when
        Hand hand = new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.HEART),
                new Card(Rank.SEVEN, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        ));
        boolean hasFourOfAKind = dealer.hasFourOfAKind(hand);

        // then
        assertTrue(hasFourOfAKind);
        assertFalse(dealer.hasTwoPair(hand));
    }

    @Test
    void hand_with_three_seven_is_not_a_four_of_a_kind() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasFourOfAKind = dealer.hasFourOfAKind(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.HEART),
                new Card(Rank.JACK, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        )));

        // then
        assertFalse(hasFourOfAKind);
    }

    @Test
    void hand_with_three_seven_is_a_three_of_a_kind() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasThreeOfAKind = dealer.hasThreeOfAKind(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.HEART),
                new Card(Rank.EIGHT, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        )));

        // then
        assertTrue(hasThreeOfAKind);
    }

    @Test
    void hand_with_no_three_seven_is_a_not_a_three_of_a_kind() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasThreeOfAKind = dealer.hasThreeOfAKind(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.DIAMOND),
                new Card(Rank.EIGHT, Color.HEART),
                new Card(Rank.EIGHT, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        )));

        // then
        assertFalse(hasThreeOfAKind);
    }

    @Test
    void hand_with_two_seven_is_a_pair() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasPair = dealer.hasPair(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.DIAMOND),
                new Card(Rank.SIX, Color.HEART),
                new Card(Rank.EIGHT, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        )));

        // then
        assertTrue(hasPair);
    }

    @Test
    void hand_with_two_five_is_a_pair() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasPair = dealer.hasPair(new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.SIX, Color.HEART),
                new Card(Rank.EIGHT, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        )));

        // then
        assertTrue(hasPair);
    }

    @Test
    void hand_with_three_card_of_seven_is_a_not_a_pair() {
        // given
        Dealer dealer = new Dealer();

        // when
        boolean hasPair = dealer.hasPair(new Hand(List.of(
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.SEVEN, Color.HEART),
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.EIGHT, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        )));

        // then
        assertFalse(hasPair);
    }

    @Test
    void five_distinct_cards_is_not_a_special_hand() {
        // given
        Dealer dealer = new Dealer();

        // when
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.DIAMOND),
                new Card(Rank.SIX, Color.HEART),
                new Card(Rank.EIGHT, Color.DIAMOND),
                new Card(Rank.QUEEN, Color.HEART)
        ));

        // then
        assertFalse(dealer.hasPair(hand));
        assertFalse(dealer.hasFullHouse(hand));
        assertFalse(dealer.hasThreeOfAKind(hand));
        assertFalse(dealer.hasFourOfAKind(hand));
        assertFalse(dealer.hasFlush(hand));
    }
}
