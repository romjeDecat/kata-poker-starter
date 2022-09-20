package com.decathlon.katas.progfunc.poker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    private final Dealer dealer;

    public PersonTest() {
        this.dealer = new Dealer();
    }

    @Test
    @DisplayName("Assert that a hand is invalid without five card")
    public void isHandInvalidWithoutFiveCards() {
        assertThrows(IllegalArgumentException.class, () -> {
            Hand invalidHand = new Hand(List.of(
                    new Card(Rank.FIVE, Color.TREFLE),
                    new Card(Rank.FOUR, Color.DIAMOND)
            ));
        });
    }

    @Test
    @DisplayName("Assert that a pair is well formed")
    public void isHandAPair() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),

                new Card(Rank.TEN, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.SPADE),
                new Card(Rank.KING, Color.HEART)
        ));

        // When
        // Then
        assertTrue(dealer.verifyHasPair(hand));
    }

    @Test
    @DisplayName("Assert that a non pair is well formed")
    public void isHandNotAPair() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.TEN, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.SPADE),
                new Card(Rank.KING, Color.HEART)
        ));

        // When
        // Then
        assertFalse(dealer.verifyHasPair(hand));
    }

    @Test
    @DisplayName("Assert hand contain a three of a kind")
    public void isHandAThreeOfAKind() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.SPADE),
                new Card(Rank.KING, Color.HEART)
        ));

        // When
        // Then
        assertTrue(dealer.verifyHasThreeOfAKind(hand));
        assertFalse(dealer.verifyHasPair(hand));
    }

    @Test
    @DisplayName("Assert hand doesn't contain a three of a kind")
    public void isHandNotAThreeOfAKind() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.SPADE),
                new Card(Rank.KING, Color.HEART)
        ));

        // When
        // Then
        assertFalse(dealer.verifyHasThreeOfAKind(hand));
    }

    @Test
    @DisplayName("Assert hand contain a four of a kind")
    public void isHandAFourOfAKind() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.KING, Color.HEART)
        ));

        // When
        // Then
        assertTrue(dealer.verifyHasFourOfAKind(hand));
        assertFalse(dealer.verifyHasThreeOfAKind(hand));
        assertFalse(dealer.verifyHasPair(hand));
    }

    @Test
    @DisplayName("Assert hand doesn't contain a four of a kind")
    public void isHandNotAFourOfAKind() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.SPADE),
                new Card(Rank.KING, Color.HEART)
        ));

        // When
        // Then
        assertFalse(dealer.verifyHasFourOfAKind(hand));
    }

    @Test
    @DisplayName("Assert that a hand is a full house")
    public void isHandAFullHouse() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.FOUR, Color.SPADE),
                new Card(Rank.FOUR, Color.HEART)
        ));

        // When
        // Then
        assertTrue(dealer.verifyHasFullHouse(hand));
    }

    @Test
    @DisplayName("Assert that a hand is not a full house")
    public void isHandNotAFullHouse() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.KING, Color.SPADE),
                new Card(Rank.FOUR, Color.HEART)
        ));

        // When
        // Then
        assertFalse(dealer.verifyHasFullHouse(hand));
    }

    @Test
    @DisplayName("Assert that a hand contain two pair")
    public void isHandTwoPair() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.FOUR, Color.SPADE),
                new Card(Rank.TEN, Color.HEART)
        ));

        // When
        // Then
        assertTrue(dealer.verifyHasTwoPair(hand));
    }

    @Test
    @DisplayName("Assert that a hand does not contain two pair")
    public void isHandNotTwoPair() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.FOUR, Color.DIAMOND),
                new Card(Rank.JACK, Color.HEART),
                new Card(Rank.KING, Color.SPADE)
        ));

        // When
        // Then
        assertFalse(dealer.verifyHasTwoPair(hand));
    }

    @Test
    @DisplayName("Assert that a hand does not contain two pair")
    public void isHandTwoIdenticalPair() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.THREE, Color.DIAMOND)
        ));

        // When
        // Then
        assertFalse(dealer.verifyHasTwoPair(hand));
    }

    @Test
    @DisplayName("Assert that a hand contain a color")
    public void isHandAColor() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.KING, Color.TREFLE),
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.THREE, Color.TREFLE)
        ));

        // When
        // Then
        assertTrue(dealer.verifyHasColor(hand));
    }

    @Test
    @DisplayName("Assert that a hand does not contain a color")
    public void isHandNotAColor() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.KING, Color.TREFLE),
                new Card(Rank.SEVEN, Color.TREFLE),
                new Card(Rank.FIVE, Color.HEART),
                new Card(Rank.THREE, Color.TREFLE)
        ));

        // When
        // Then
        assertFalse(dealer.verifyHasColor(hand));
    }

    @Test
    @DisplayName("Assert that a hand is a straight 1,2,3,4,5")
    public void isHandAStraightOnACE() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.ACE, Color.TREFLE),
                new Card(Rank.TWO, Color.TREFLE),
                new Card(Rank.THREE, Color.TREFLE),
                new Card(Rank.FOUR, Color.TREFLE),
                new Card(Rank.FIVE, Color.HEART)
        ));

        // When
        // Then
        assertTrue(dealer.verifyHasStraight(hand));
    }

    @Test
    @DisplayName("Assert that a hand is a straight 10,J,Q,K,1")
    public void isHandAStraightOnTen() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.TEN, Color.TREFLE),
                new Card(Rank.JACK, Color.TREFLE),
                new Card(Rank.QUEEN, Color.TREFLE),
                new Card(Rank.KING, Color.TREFLE),
                new Card(Rank.ACE, Color.HEART)
        ));

        // When
        // Then
        assertTrue(dealer.verifyHasStraight(hand));
    }

    @Test
    @DisplayName("Assert that a hand is not a straight 1,2,4,5,6")
    public void isHandNotAStraight() {
        // Given
        Hand hand = new Hand(List.of(
                new Card(Rank.ACE, Color.TREFLE),
                new Card(Rank.TWO, Color.TREFLE),
                new Card(Rank.FOUR, Color.TREFLE),
                new Card(Rank.FIVE, Color.TREFLE),
                new Card(Rank.SIX, Color.HEART)
        ));

        // When
        // Then
        assertFalse(dealer.verifyHasStraight(hand));
    }
}
