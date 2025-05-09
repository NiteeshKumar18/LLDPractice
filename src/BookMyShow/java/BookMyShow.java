package BookMyShow.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BookMyShow {

    private final MovieController movieController;

    private final TheaterController theaterController;

    public BookMyShow() {
        this.movieController = new MovieController();
        this.theaterController = new TheaterController();
    }

    public void initializeBookMyShow() {

    }


    public void createTheaters() {
        List<Screen> screens1 = createScreensForTheaters();
        Theater theater1 = new Theater(ThreadLocalRandom.current().nextInt(),"PVP1", screens1);
    }

    public void createMovies() {
        Movie movie1 = new Movie(ThreadLocalRandom.current().nextInt(),"BAHUBALI", List.of("me","meAndMyWife"),2,"18+");
        Movie movie2 = new Movie(ThreadLocalRandom.current().nextInt(),"BAHUBALI2", List.of("me","meAndMyWife"),2,"18+");
        Movie movie3 = new Movie(ThreadLocalRandom.current().nextInt(),"BAHUBALI3", List.of("me","meAndMyWife"),2,"18+");

    }

    public void createShows(List<Screen> screens) {
        Movie movie1 = new Movie(ThreadLocalRandom.current().nextInt(),"BAHUBALI", List.of("me","meAndMyWife"),2,"18+");
        Show bblShow1 = new Show(ThreadLocalRandom.current().nextInt(),movie1,screens.get(0));
    }

    public List<Screen> createScreensForTheaters() {
        Screen screen1 = new Screen(ThreadLocalRandom.current().nextInt(1,10), Screen.Dimension.TWO_DIMENSIONAL,"DOLBY" );
        Screen screen2 = new Screen(ThreadLocalRandom.current().nextInt(1,10), Screen.Dimension.TWO_DIMENSIONAL,"DOLBY" );
        return List.of(screen1,screen2);
    }

}
