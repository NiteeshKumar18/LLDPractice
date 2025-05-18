package DesignPatterns.FlyweightDesignPattern.RobotExample;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {

    private static Map<String, IRobot> robotCache = new HashMap<>();


    public static IRobot getRobot(String type) {
        if (robotCache.containsKey(type)) {
            return robotCache.get(type);
        } else {
            if (type == "HUMANOID") {
                HumanoidRobot robot = new HumanoidRobot("Humanoid", new Sprites());
                robotCache.put("Humanoid", robot);
                return robot;
            } else {
                DogRobot dogRobot = new DogRobot("dog", new Sprites());
                robotCache.put("Dog", dogRobot);
                return dogRobot;
            }
        }
    }
}
