package org.codingdojo.yatzy1;

import java.util.stream.IntStream;

public class Yatzy1 {

    public int chance(DiceRoll diceRoll)
    {
        return dices(diceRoll).sum();
    }

    public int yatzy(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        int[] dices= {diceRoll.getD1(), diceRoll.getD2(), diceRoll.getD3(), diceRoll.getD4(), diceRoll.getD5()};
        for (int dice : dices){
            counts[dice-1]++;
        }

        for (int i = 0; i < 6; i++){
            if (counts[i] == 5){
                return 50;
            }
        }
        return 0;
    }

    public int ones(DiceRoll diceRoll) {
        return dices(diceRoll).filter(value -> value == 1).sum();
    }

    public int twos(DiceRoll diceRoll) {
        return dices(diceRoll).filter(value -> value == 2).sum();
    }

    public int threes(DiceRoll diceRoll) {
        return dices(diceRoll).filter(value -> value == 3).sum();
    }

    public int fours(DiceRoll diceRoll)
    {
        return dices(diceRoll).filter(value -> value == 4).sum();
    }

    public int fives(DiceRoll diceRoll)
    {
        return dices(diceRoll).filter(value -> value == 5).sum();
    }

    public int sixes(DiceRoll diceRoll)
    {
        return dices(diceRoll).filter(value -> value == 6).sum();
    }

    public int onePair(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1]++;
        counts[diceRoll.getD2() -1]++;
        counts[diceRoll.getD3() -1]++;
        counts[diceRoll.getD4() -1]++;
        counts[diceRoll.getD5() -1]++;
        for (int i = 0; i < 6; i++){
            if (counts[6-i-1] >= 2)
                return (6-i)*2;
        }
        return 0;
    }

    public int twoPairs(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1]++;
        counts[diceRoll.getD2() -1]++;
        counts[diceRoll.getD3() -1]++;
        counts[diceRoll.getD4() -1]++;
        counts[diceRoll.getD5() -1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i ++){
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        }
        return n == 2 ? score * 2 : 0;
    }

    public int fourOfAKind(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1]++;
        counts[diceRoll.getD2() -1]++;
        counts[diceRoll.getD3() -1]++;
        counts[diceRoll.getD4() -1]++;
        counts[diceRoll.getD5() -1]++;
        for (int i = 0; i < 6; i++){
            if (counts[i] >= 4)
                return (i+1) * 4;
        }
        return 0;
    }

    public int threeOfAKind(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1]++;
        counts[diceRoll.getD2() -1]++;
        counts[diceRoll.getD3() -1]++;
        counts[diceRoll.getD4() -1]++;
        counts[diceRoll.getD5() -1]++;
        for (int i = 0; i < 6; i++){
            if (counts[i] >= 3)
                return (i+1) * 3;
        }
        return 0;
    }

    public int smallStraight(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() - 1]++;
        counts[diceRoll.getD2() - 1]++;
        counts[diceRoll.getD3() - 1]++;
        counts[diceRoll.getD4() - 1]++;
        counts[diceRoll.getD5() - 1]++;
        if (counts[0] == 1 &&
            counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1)
            return 15;
        return 0;
    }

    public int largeStraight(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() - 1]++;
        counts[diceRoll.getD2() - 1]++;
        counts[diceRoll.getD3() - 1]++;
        counts[diceRoll.getD4() - 1]++;
        counts[diceRoll.getD5() - 1]++;
        if (counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1
            && counts[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() - 1]++;
        counts[diceRoll.getD2() - 1]++;
        counts[diceRoll.getD3() - 1]++;
        counts[diceRoll.getD4() - 1]++;
        counts[diceRoll.getD5() - 1]++;

        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        for (i = 0; i < 6; i++) {
            if (counts[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }
        }

        for (i = 0; i < 6; i++) {
            if (counts[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }
        }

        return _2 && _3 ? _2_at * 2 + _3_at * 3 : 0;
    }

    private static IntStream dices(DiceRoll diceRoll) {
        return IntStream.of(
            diceRoll.getD1(),
            diceRoll.getD2(),
            diceRoll.getD3(),
            diceRoll.getD4(),
            diceRoll.getD5()
        );
    }
}



