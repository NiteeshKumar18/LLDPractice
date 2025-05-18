package DesignPatterns.FlyweightDesignPattern.RobotExample;

import DesignPatterns.FlyweightDesignPattern.RobotExample.IRobot;
import DesignPatterns.FlyweightDesignPattern.RobotExample.RobotFactory;

public class Main {
    public static void main(String[] args) {
        IRobot humanoidRobo1 = RobotFactory.getRobot("Humanoid");
        humanoidRobo1.display(1, 2);



        /*

        Take away: Lets say i want to create 5 lakhs robos of each type and sprites for each robo is very high in memory.So i dont want to create that many objects, instead we made a cache and stored all the common data including sprites as its common to every one
         */
    }
}
