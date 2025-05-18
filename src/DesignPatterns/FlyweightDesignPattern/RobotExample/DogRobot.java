package DesignPatterns.FlyweightDesignPattern.RobotExample;

public class DogRobot implements IRobot {

    private String type;

    private Sprites sprites;


    public DogRobot(String type, Sprites sprites) {
        this.sprites = sprites;
        this.type = type;
    }

    @Override
    public void display(int x, int y) {

    }
}
