package CricBuzz.Team;

import java.util.Deque;
import java.util.LinkedList;

public class BattingController {

    private Deque<Player> battingOrder = new LinkedList<>();
    private Player currentStriker;

    private Player currentNonStriker;


    public void putNewPlayerInStriker() {
        Player player = battingOrder.peekFirst();
        this.currentStriker = player;
    }

    public void putNewPlayerInNonStriker() {
        Player player = battingOrder.peekFirst();
        this.currentNonStriker = player;
    }

    public void rotateStrike() {
        Player temp = currentStriker;
        currentStriker = currentNonStriker;
        currentNonStriker = temp;
    }

    public Player getStriker(){
        return this.currentStriker;
    }
}
