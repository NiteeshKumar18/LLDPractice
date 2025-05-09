package BookMyShow.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    private Map<Location.City, List<Movie>> cityToMovieMap = new HashMap<>();
    private List<Movie> allMovies = new ArrayList<>();

    public void setCityToMovieMap(Map<Location.City,List<Movie>> map){
        this.cityToMovieMap = map;
    }
}
