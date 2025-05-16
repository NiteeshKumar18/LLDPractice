package CricBuzz.Team;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BowlingController {

    private Deque<Player> bowlingPlayers = new LinkedList<>();
    private List<Player> quotaFinishedPlayers = new ArrayList<>();

    private Player currentBowler;


    public Player bringNextBowler(int limitOvers) {
        Player currentBowlerLocal = bowlingPlayers.removeFirst();
        if (currentBowlerLocal.getBowlingScorecard().getNoOfOversBowled() >= limitOvers) {
            quotaFinishedPlayers.add(currentBowlerLocal);
        } else {
            bowlingPlayers.addLast(currentBowlerLocal);
        }

        this.currentBowler = bowlingPlayers.getFirst();
        return this.currentBowler;
    }

    public Player getCurrentBowler() {
        return this.currentBowler;
    }

}
