package com.decathlon.katas.progfunc.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandValidityTest {
    @Test
    void four_cards_is_not_a_valid_hand() {
        // given
        List<Card> cards = List.of(
                new Card(Rank.FIVE, Color.DIAMOND),
                new Card(Rank.SEVEN, Color.DIAMOND),
                new Card(Rank.SIX, Color.HEART),
                new Card(Rank.EIGHT, Color.DIAMOND)
        );

        // when-then
        assertThrows(IllegalArgumentException.class, () -> new Hand(cards));
    }
}
