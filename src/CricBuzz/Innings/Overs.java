package CricBuzz.Innings;

import CricBuzz.Team.Player;
import CricBuzz.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class Overs {

    private int overNo;

    private Player bowledBy;

    private List<Balls> balls = new ArrayList<>();

    public Overs(int overNo) {
        this.overNo = overNo;
    }


    public boolean playOver(Team bowlingTeam, Team battingTeam, int runsToWin) {
        battingTeam.getBattingController().rotateStrike();
        bowlingTeam.getBowlingController().bringNextBowler(5);
        List<Balls> ballsLocal = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Balls balls = new Balls(i,this.overNo);
            balls.playBall(bowlingTeam, battingTeam);
            ballsLocal.add(balls);

            if (runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin) {
                battingTeam.setIsWinner(true);
                return true;
            }
        }
        this.balls = ballsLocal;
        return false;
    }
}
