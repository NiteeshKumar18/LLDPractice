package BookMyShow.java;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private final int theaterId;
    private final String name;
    private List<Screen> screens;

    private String location;


    public Theater(int theaterId, String name, List<Screen> screens){
        this.theaterId = theaterId;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    private List<String> shows;

}
