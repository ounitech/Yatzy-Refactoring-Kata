package org.codingdojo.yatzy1;

public class Yatzy1 {

    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        int total = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        int[] dices= {d1, d2, d3, d4, d5};
        for (int dice : dices){
            counts[dice-1]++;
        }
        for (int i = 0; i != 6; i++){
            if (counts[i] == 5)
                return 50;
        }
        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 1) sum++;
        if (d2 == 1) sum++;
        if (d3 == 1) sum++;
        if (d4 == 1) sum++;
        if (d5 == 1) sum++;
        return sum;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 2) sum += 2;
        if (d2 == 2) sum += 2;
        if (d3 == 2) sum += 2;
        if (d4 == 2) sum += 2;
        if (d5 == 2) sum += 2;
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 3) sum += 3;
        if (d2 == 3) sum += 3;
        if (d3 == 3) sum += 3;
        if (d4 == 3) sum += 3;
        if (d5 == 3) sum += 3;
        return sum;
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5)
    {
        int sum = 0;
        if (d1 == 4) sum += 4;
        if (d2 == 4) sum += 4;
        if (d3 == 4) sum += 4;
        if (d4 == 4) sum += 4;
        if (d5 == 4) sum += 4;
        return sum;
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5)
    {
        int sum = 0;
        if (d1 == 5) sum += 5;
        if (d2 == 5) sum += 5;
        if (d3 == 5) sum += 5;
        if (d4 == 5) sum += 5;
        if (d5 == 5) sum += 5;
        return sum;
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5)
    {
        int sum = 0;
        if (d1 == 6) sum += 6;
        if (d2 == 6) sum += 6;
        if (d3 == 6) sum += 6;
        if (d4 == 6) sum += 6;
        if (d5 == 6) sum += 6;
        return sum;
    }

    public static int onePair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        for (int i = 0; i != 6; i++){
            if (counts[6-i-1] >= 2)
                return (6-i)*2;
        }
        return 0;
    }

    public static int twoPairs(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
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

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        for (int i = 0; i < 6; i++){
            if (counts[i] >= 4)
                return (i+1) * 4;
        }
        return 0;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        for (int i = 0; i < 6; i++){
            if (counts[i] >= 3)
                return (i+1) * 3;
        }
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts;
        counts = new int[6];
        counts[d1-1] += 1;
        counts[d2-1] += 1;
        counts[d3-1] += 1;
        counts[d4-1] += 1;
        counts[d5-1] += 1;
        if (counts[0] == 1 &&
            counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1] += 1;
        counts[d2-1] += 1;
        counts[d3-1] += 1;
        counts[d4-1] += 1;
        counts[d5-1] += 1;
        if (counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1
            && counts[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1] += 1;
        counts[d2-1] += 1;
        counts[d3-1] += 1;
        counts[d4-1] += 1;
        counts[d5-1] += 1;

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



