package org.codingdojo.yatzy1;

public class Yatzy1 {

    public int chance(DiceRoll diceRoll)
    {
        return diceRoll.dices().sum();
    }

    public int yatzy(DiceRoll diceRoll)
    {
        int[] counts = countOccurrences(diceRoll);
        for (int i = 0; i < 6; i++){
            if (counts[i] == 5){
                return 50;
            }
        }
        return 0;
    }

    public int ones(DiceRoll diceRoll) {
        return diceRoll.dices().filter(value -> value == 1).sum();
    }

    public int twos(DiceRoll diceRoll) {
        return diceRoll.dices().filter(value -> value == 2).sum();
    }

    public int threes(DiceRoll diceRoll) {
        return diceRoll.dices().filter(value -> value == 3).sum();
    }

    public int fours(DiceRoll diceRoll)
    {
        return diceRoll.dices().filter(value -> value == 4).sum();
    }

    public int fives(DiceRoll diceRoll)
    {
        return diceRoll.dices().filter(value -> value == 5).sum();
    }

    public int sixes(DiceRoll diceRoll)
    {
        return diceRoll.dices().filter(value -> value == 6).sum();
    }

    public int onePair(DiceRoll diceRoll)
    {
        int[] counts = countOccurrences(diceRoll);
        for (int i = 0; i < 6; i++){
            if (counts[6-i-1] >= 2) { // reverse order to capture the highest pair first
                return (6-i)*2;
            }
        }
        return 0;
    }

    public int twoPairs(DiceRoll diceRoll)
    {
        int[] counts = countOccurrences(diceRoll);
        int numberOfPairs = 0;
        int score = 0;
        for (int i = 0; i < 6; i ++){
            if (counts[6-i-1] >= 2) { // TODO no need for reverse order here (never mind)
                numberOfPairs++;
                score += (6-i);
            }
        }
        return numberOfPairs == 2 ? score * 2 : 0;
    }

    public int fourOfAKind(DiceRoll diceRoll)
    {
        int[] counts = countOccurrences(diceRoll);
        for (int i = 0; i < 6; i++){
            if (counts[i] >= 4) {
                return (i+1) * 4;
            }
        }
        return 0;
    }

    public int threeOfAKind(DiceRoll diceRoll)
    {
        int[] counts = countOccurrences(diceRoll);
        for (int i = 0; i < 6; i++){
            if (counts[i] >= 3) {
                return (i+1) * 3;
            }
        }
        return 0;
    }

    public int smallStraight(DiceRoll diceRoll)
    {
        int[] counts = countOccurrences(diceRoll);
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
        int[] counts = countOccurrences(diceRoll);
        if (counts[1] == 1 &&
            counts[2] == 1 &&
            counts[3] == 1 &&
            counts[4] == 1 &&
            counts[5] == 1)
            return 20;
        return 0;
    }

    public int fullHouse(DiceRoll diceRoll)
    {
        int[] counts = countOccurrences(diceRoll);

        boolean isThereAPair = false;
        int pairIndex = 0;

        for (int i = 0; i < 6; i++) {
            if (counts[i] == 2) {
                isThereAPair = true;
                pairIndex = i + 1;
            }
        }

        boolean isThereThreeofAkind = false;
        int threeOfAKindIndex = 0;
        for (int i = 0; i < 6; i++) {
            if (counts[i] == 3) {
                isThereThreeofAkind = true;
                threeOfAKindIndex = i + 1;
            }
        }

        return isThereAPair && isThereThreeofAkind ? pairIndex * 2 + threeOfAKindIndex * 3 : 0;
    }


    /**
     * calculate the occurrence of a number in a DiceRoll
     * and returns an array with these occurrences at index-1
     *  The occurrence of ones is in index 0
     *  The occurrence of sixes is in index 5
     * @param diceRoll
     * @return array of size 5
     */
    private static int[] countOccurrences(DiceRoll diceRoll) {
        int[] counts = new int[6];
        counts[diceRoll.getD1() -1]++;
        counts[diceRoll.getD2() -1]++;
        counts[diceRoll.getD3() -1]++;
        counts[diceRoll.getD4() -1]++;
        counts[diceRoll.getD5() -1]++;
        return counts;
    }
}



