package BookMyShow.java;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Movie {

    private final int movieId;
    private final String movieName;

    private final List<String> cast;

    private final int avgReview;

    private final String rating;

    public Movie(int movieId, String name, List<String> casr, int review, String rating){
        this.movieId = ThreadLocalRandom.current().nextInt(1,4);
        this.movieName = name;
        this.cast = List.of("12","23","34");
        this.avgReview = ThreadLocalRandom.current().nextInt(1,3);
        this.rating = rating;
    }

    public String getMovieName(){
        return this.movieName;
    }
}
