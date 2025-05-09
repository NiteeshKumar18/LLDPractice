package BookMyShow.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {
    private Map<Location, List<Theater>> locToTheaterMap= new HashMap<>();
    private List<Theater> allTheaters = new ArrayList<>();

    public void initialiseTheaterController(Map<Location, List<Theater>> map, List<Theater> all){
        this.locToTheaterMap = map;
        this.allTheaters = all;
    }
}
