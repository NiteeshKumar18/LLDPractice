package BookMyShow.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {

    private final int showId;
    private final Movie movie;

    private final Screen screen;

    private List<Seat> bookedSeats = new ArrayList<>();
    private final Date showTimings;

    public Show(int showId, Movie movie, Screen screen){
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showTimings = new Date();
    }

    public Screen getScreen(){
        return this.screen;
    }

    public void updateBookedSeats(List<Seat> seats){
        this.bookedSeats = seats;
    }


}
