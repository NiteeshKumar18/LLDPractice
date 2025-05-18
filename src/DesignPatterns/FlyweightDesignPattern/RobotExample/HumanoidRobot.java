package DesignPatterns.FlyweightDesignPattern.RobotExample;

public class HumanoidRobot implements IRobot {

    private String type;

    private Sprites sprites;


    HumanoidRobot(String type, Sprites sprites) {
        this.sprites = sprites;
        this.type = type;
    }


    @Override
    public void display(int x, int y) {

    }
}
