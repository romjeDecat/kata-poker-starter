package com.decathlon.katas.progfunc.poker;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * tests suite for poker hands evaluation
 *
 * @author deadbrain
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HandTest {

    @Test
    void valid_hand_should_have_five_cards() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Hand(Collections.emptyList())
        );
    }

}
