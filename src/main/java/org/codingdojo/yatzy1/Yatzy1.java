package org.codingdojo.yatzy1;

public class Yatzy1 {

    public static int chance(DiceRoll diceRoll)
    {
        int total = 0;
        total += diceRoll.getD1();
        total += diceRoll.getD2();
        total += diceRoll.getD3();
        total += diceRoll.getD4();
        total += diceRoll.getD5();
        return total;
    }

    public static int yatzy(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        int[] dices= {diceRoll.getD1(), diceRoll.getD2(), diceRoll.getD3(), diceRoll.getD4(), diceRoll.getD5()};
        for (int dice : dices){
            counts[dice-1]++;
        }
        for (int i = 0; i != 6; i++){
            if (counts[i] == 5)
                return 50;
        }
        return 0;
    }

    public static int ones(DiceRoll diceRoll) {
        int sum = 0;
        if (diceRoll.getD1() == 1) sum++;
        if (diceRoll.getD2() == 1) sum++;
        if (diceRoll.getD3() == 1) sum++;
        if (diceRoll.getD4() == 1) sum++;
        if (diceRoll.getD5() == 1) sum++;
        return sum;
    }

    public static int twos(DiceRoll diceRoll) {
        int sum = 0;
        if (diceRoll.getD1() == 2) sum += 2;
        if (diceRoll.getD2() == 2) sum += 2;
        if (diceRoll.getD3() == 2) sum += 2;
        if (diceRoll.getD4() == 2) sum += 2;
        if (diceRoll.getD5() == 2) sum += 2;
        return sum;
    }

    public static int threes(DiceRoll diceRoll) {
        int sum = 0;
        if (diceRoll.getD1() == 3) sum += 3;
        if (diceRoll.getD2() == 3) sum += 3;
        if (diceRoll.getD3() == 3) sum += 3;
        if (diceRoll.getD4() == 3) sum += 3;
        if (diceRoll.getD5() == 3) sum += 3;
        return sum;
    }

    public static int fours(DiceRoll diceRoll)
    {
        int sum = 0;
        if (diceRoll.getD1() == 4) sum += 4;
        if (diceRoll.getD2() == 4) sum += 4;
        if (diceRoll.getD3() == 4) sum += 4;
        if (diceRoll.getD4() == 4) sum += 4;
        if (diceRoll.getD5() == 4) sum += 4;
        return sum;
    }

    public static int fives(DiceRoll diceRoll)
    {
        int sum = 0;
        if (diceRoll.getD1() == 5) sum += 5;
        if (diceRoll.getD2() == 5) sum += 5;
        if (diceRoll.getD3() == 5) sum += 5;
        if (diceRoll.getD4() == 5) sum += 5;
        if (diceRoll.getD5() == 5) sum += 5;
        return sum;
    }

    public static int sixes(DiceRoll diceRoll)
    {
        int sum = 0;
        if (diceRoll.getD1() == 6) sum += 6;
        if (diceRoll.getD2() == 6) sum += 6;
        if (diceRoll.getD3() == 6) sum += 6;
        if (diceRoll.getD4() == 6) sum += 6;
        if (diceRoll.getD5() == 6) sum += 6;
        return sum;
    }

    public static int onePair(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1]++;
        counts[diceRoll.getD2() -1]++;
        counts[diceRoll.getD3() -1]++;
        counts[diceRoll.getD4() -1]++;
        counts[diceRoll.getD5() -1]++;
        for (int i = 0; i != 6; i++){
            if (counts[6-i-1] >= 2)
                return (6-i)*2;
        }
        return 0;
    }

    public static int twoPairs(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1]++;
        counts[diceRoll.getD2() -1]++;
        counts[diceRoll.getD3() -1]++;
        counts[diceRoll.getD4() -1]++;
        counts[diceRoll.getD5() -1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1){
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        }
        return n == 2 ? score * 2 : 0;
    }

    public static int fourOfAKind(DiceRoll diceRoll)
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

    public static int threeOfAKind(DiceRoll diceRoll)
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

    public static int smallStraight(DiceRoll diceRoll)
    {
        int[] counts;
        counts = new int[6];
        counts[diceRoll.getD1() -1] += 1;
        counts[diceRoll.getD2() -1] += 1;
        counts[diceRoll.getD3() -1] += 1;
        counts[diceRoll.getD4() -1] += 1;
        counts[diceRoll.getD5() -1] += 1;
        if (counts[0] == 1 &&
            counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1] += 1;
        counts[diceRoll.getD2() -1] += 1;
        counts[diceRoll.getD3() -1] += 1;
        counts[diceRoll.getD4() -1] += 1;
        counts[diceRoll.getD5() -1] += 1;
        if (counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1
            && counts[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(DiceRoll diceRoll)
    {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1] += 1;
        counts[diceRoll.getD2() -1] += 1;
        counts[diceRoll.getD3() -1] += 1;
        counts[diceRoll.getD4() -1] += 1;
        counts[diceRoll.getD5() -1] += 1;

        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        for (i = 0; i != 6; i += 1) {
            if (counts[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }
        }

        for (i = 0; i != 6; i += 1) {
            if (counts[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }
        }

        return _2 && _3 ? _2_at * 2 + _3_at * 3 : 0;
    }
}



