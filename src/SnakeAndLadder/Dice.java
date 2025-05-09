package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private final int no;

    public Dice(int n){
        this.no = n;
    }

    public int rollDice(){
        int sum =0;
        for(int i=1;i<=no;i++){
            System.out.println("DIce rolled");
            sum = sum+ ThreadLocalRandom.current().nextInt(1,6);
        }

        return sum;
    }
}
