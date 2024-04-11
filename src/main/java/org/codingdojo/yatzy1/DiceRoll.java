package org.codingdojo.yatzy1;

import java.util.Objects;

public final class DiceRoll {

    private final int d1;
    private final int d2;
    private final int d3;
    private final int d4;
    private final int d5;

    public DiceRoll(int d1, int d2, int d3, int d4, int d5) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
    }

    public int getD5() {
        return d5;
    }

    public int getD4() {
        return d4;
    }

    public int getD3() {
        return d3;
    }

    public int getD2() {
        return d2;
    }

    public int getD1() {
        return d1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DiceRoll) obj;
        return this.d1 == that.d1 &&
            this.d2 == that.d2 &&
            this.d3 == that.d3 &&
            this.d4 == that.d4 &&
            this.d5 == that.d5;
    }

    @Override
    public int hashCode() {
        return Objects.hash(d1, d2, d3, d4, d5);
    }

    @Override
    public String toString() {
        return "DiceRoll[" +
            "d1=" + d1 + ", " +
            "d2=" + d2 + ", " +
            "d3=" + d3 + ", " +
            "d4=" + d4 + ", " +
            "d5=" + d5 + ']';
    }

}