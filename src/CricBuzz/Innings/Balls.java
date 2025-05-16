package CricBuzz.Innings;

import CricBuzz.ScoreUpdateObserver.BattingScoreUpdater;
import CricBuzz.ScoreUpdateObserver.BowlingScoreUpdater;
import CricBuzz.ScoreUpdateObserver.ScoreUpdateObserver;
import CricBuzz.Team.Player;
import CricBuzz.Team.Team;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Balls {


    private int overNo;

    private int ballNo;

    private boolean wicketTaken;

    private Player battedBy;

    private Player bowledBy;

    private RunType runType;

    private BowlingScoreUpdater bowlingScoreUpdater;

    private BattingScoreUpdater battingScoreUpdater;

    public Player getBattedBy() {
        return this.battedBy;
    }

    public Player getBowledBy() {
        return this.bowledBy;
    }

    public int getOverNo() {
        return this.overNo;
    }

    public int getBallNo() {
        return this.ballNo;
    }

    public RunType getRunType() {

        return this.runType;
    }

    public Balls(int ballNo, int overN0) {
        this.ballNo = ballNo;
        this.overNo = overN0;
        this.battingScoreUpdater = new BattingScoreUpdater();
        this.bowlingScoreUpdater = new BowlingScoreUpdater();
    }


    public void playBall(Team bowlingTeam, Team battingTeam) {
        this.battedBy = battingTeam.getBattingController().getStriker();
        this.bowledBy = bowlingTeam.getBowlingController().getCurrentBowler();
        boolean isWicketTaken = isWicket();
        if (isWicketTaken) {
            this.wicketTaken = true;
            battingTeam.getBattingController().putNewPlayerInStriker();

        } else {
            RunType runType = getRandomRunTypeForBall();
            this.runType = runType;
            if (runType == RunType.ONE || runType == RunType.TWO) {
                battingTeam.getBattingController().rotateStrike();

            }
        }

        battingScoreUpdater.updateBallDetails(this);
        bowlingScoreUpdater.updateBallDetails(this);

    }


    public boolean isWicket() {
        int random = ThreadLocalRandom.current().nextInt(1, 10);
        if (random > 7) {
            return true;
        }
        return false;
    }

    public RunType getRandomRunTypeForBall() {
        int run = ThreadLocalRandom.current().nextInt(1, 7);
        return RunType.getRunTypeForValue(run);
    }

}
