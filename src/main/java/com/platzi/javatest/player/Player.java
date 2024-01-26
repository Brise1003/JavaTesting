package com.platzi.javatest.player;

public class Player {

    private Dice dice;
    private int mimNumberToWin;

    public Player(Dice dice, int mimNumberToWin) {
        this.dice = dice;
        this.mimNumberToWin = mimNumberToWin;
    }

    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber > mimNumberToWin;
    }
}
