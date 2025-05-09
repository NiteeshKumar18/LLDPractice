package BookMyShow.java;

public class Screen {

    private final int screenId;
    private final Dimension screenType;

    private final String soundSystemType;

    private final Seat[][] seatsArray = new Seat[100][100];


    public Screen(int screenId, Dimension screenType, String soundSystemType){
        this.screenId = screenId;
        this.screenType = screenType;
        this.soundSystemType = soundSystemType;

    }

    public Seat[][] getSeatsArray(){
        return this.seatsArray;
    }


    public enum Dimension {
       TWO_DIMENSIONAL, THREE_DIMENSIONAL
    }
}
