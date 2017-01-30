package com.scapp281.crap;

import java.security.SecureRandom;

public class Dice {
    private static final SecureRandom random = new SecureRandom();
    private int x;
    private int y;

    public int rollDice() {
        x = 1 + random.nextInt(6);
        y = 1 + random.nextInt(6);
        return x + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
