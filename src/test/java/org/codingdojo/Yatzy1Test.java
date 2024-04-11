package org.codingdojo;

import org.codingdojo.yatzy1.DiceRoll;
import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Yatzy1Test {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy1.chance(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(16, Yatzy1.chance(new DiceRoll(3, 3, 4, 5, 1)));
    }

    @Test public void yatzy_scores_50() {
        assertEquals(50, Yatzy1.yatzy(new DiceRoll(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy1.yatzy(new DiceRoll(6, 6, 6, 6, 6)));
        assertEquals(0, Yatzy1.yatzy(new DiceRoll(6, 6, 6, 6, 3)));
    }

    @Test public void ones_sum_of_ones() {
        assertEquals(1, Yatzy1.ones(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy1.ones(new DiceRoll(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy1.ones(new DiceRoll(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy1.ones(new DiceRoll(1, 2, 1, 1, 1)));
    }

    @Test
    public void twos_sum_of_twos() {
        assertEquals(4, Yatzy1.twos(new DiceRoll(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy1.twos(new DiceRoll(2, 2, 2, 2, 2)));
        assertEquals(0, Yatzy1.twos(new DiceRoll(1, 3, 4, 5, 6)));
    }

    @Test
    public void threes_sum_of_threes() {
        assertEquals(6, Yatzy1.threes(new DiceRoll(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy1.threes(new DiceRoll(2, 3, 3, 3, 3)));
        assertEquals(0, Yatzy1.threes(new DiceRoll(2, 1, 4, 5, 1)));
    }

    @Test
    public void fours_sum_of_fours()
    {
        assertEquals(12, Yatzy1.fours(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(8, Yatzy1.fours(new DiceRoll(4, 4, 5, 5, 5)));
        assertEquals(4, Yatzy1.fours(new DiceRoll(4, 5, 5, 5, 5)));
        assertEquals(0, Yatzy1.fours(new DiceRoll(1, 2, 3, 5, 6)));
    }

    @Test
    public void fives_sum_of_fives() {
        assertEquals(10, Yatzy1.fives(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(15, Yatzy1.fives(new DiceRoll(4, 4, 5, 5, 5)));
        assertEquals(20, Yatzy1.fives(new DiceRoll(4, 5, 5, 5, 5)));
        assertEquals(0, Yatzy1.fives(new DiceRoll(4, 3, 3, 2, 1)));
    }

    @Test
    public void sixes_sum_of_sixes() {
        assertEquals(0, Yatzy1.sixes(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(6, Yatzy1.sixes(new DiceRoll(4, 4, 6, 5, 5)));
        assertEquals(18, Yatzy1.sixes(new DiceRoll(6, 5, 6, 6, 5)));
    }

    @Test
    public void one_pair_sum_of_highest_pair() {
        assertEquals(6, Yatzy1.onePair(new DiceRoll(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy1.onePair(new DiceRoll(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy1.onePair(new DiceRoll(5, 3, 6, 6, 5)));
        assertEquals(0, Yatzy1.onePair(new DiceRoll(1, 2, 3, 6, 5)));
    }

    @Test
    public void two_pairs_sum_of_two_different_pairs() {
        assertEquals(16, Yatzy1.twoPairs(new DiceRoll(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy1.twoPairs(new DiceRoll(3, 3, 5, 5, 5)));
        assertEquals(0, Yatzy1.twoPairs(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(0, Yatzy1.twoPairs(new DiceRoll(2, 2, 3, 4, 5)));
        assertEquals(0, Yatzy1.twoPairs(new DiceRoll(1, 2, 3, 4, 5)));
    }

    @Test
    public void three_of_a_kind_sum()
    {
        assertEquals(9, Yatzy1.threeOfAKind(new DiceRoll(3, 3, 3, 4, 5)));
        assertEquals(15, Yatzy1.threeOfAKind(new DiceRoll(5, 3, 5, 4, 5)));
        assertEquals(9, Yatzy1.threeOfAKind(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(9, Yatzy1.threeOfAKind(new DiceRoll(3, 3, 3, 3, 3)));
        assertEquals(0, Yatzy1.threeOfAKind(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(0, Yatzy1.threeOfAKind(new DiceRoll(1, 1, 3, 4, 5)));
    }

    @Test
    public void four_of_a_kind_sum() {
        assertEquals(12, Yatzy1.fourOfAKind(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(20, Yatzy1.fourOfAKind(new DiceRoll(5, 5, 5, 4, 5)));
        assertEquals(8, Yatzy1.fourOfAKind(new DiceRoll(2, 2, 2, 2, 2)));
        assertEquals(0, Yatzy1.fourOfAKind(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(0, Yatzy1.fourOfAKind(new DiceRoll(1, 1, 1, 4, 4)));
    }

    @Test
    public void small_straight_sum_15() {
        assertEquals(15, Yatzy1.smallStraight(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy1.smallStraight(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(0, Yatzy1.smallStraight(new DiceRoll(1, 2, 2, 4, 5)));
    }

    @Test
    public void large_straight_sum_20() {
        assertEquals(20, Yatzy1.largeStraight(new DiceRoll(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy1.largeStraight(new DiceRoll(2, 3, 4, 5, 6)));
        assertEquals(0, Yatzy1.largeStraight(new DiceRoll(1, 2, 2, 4, 5)));
    }

    @Test
    public void full_house_sum_pair_plus_three_of_a_kind() {
        assertEquals(18, Yatzy1.fullHouse(new DiceRoll(6, 2, 2, 2, 6)));
        assertEquals(0, Yatzy1.fullHouse(new DiceRoll(2, 3, 4, 5, 6)));
    }
}
