package CricBuzz.Team.Scorecards;

import CricBuzz.Team.Player;

public class BattingScorecard {

    private int runsScored;

    private int noOfFours;

    private int noOfSixes;

    private int strikeRate;

    private int noOfBallsFaced;

    private int BowledAtOver;

    private int bowledAtBall;

    private Player wicketTakenBy;

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScoredLocal) {
        this.runsScored = this.runsScored + runsScoredLocal;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public void setNoOfFours(int noOfFoursLocal) {
        this.noOfFours = this.noOfFours + noOfFoursLocal;
    }

    public int getNoOfSixes() {
        return noOfSixes;
    }

    public void setNoOfSixes(int noOfSixesLocal) {
        this.noOfSixes = this.noOfSixes + noOfSixesLocal;
    }

    public int getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(int strikeRate) {
        this.strikeRate = strikeRate;
    }

    public int getNoOfBallsFaced() {
        return noOfBallsFaced;
    }

    public void setNoOfBallsFaced(int noOfBallsFacedLocal) {
        this.noOfBallsFaced = this.noOfBallsFaced + noOfBallsFacedLocal;
    }

    public int getBowledAtOver() {
        return BowledAtOver;
    }

    public void setBowledAtOver(int bowledAtOver) {
        this.BowledAtOver = bowledAtOver;
    }

    public int getBowledAtBall() {
        return bowledAtBall;
    }

    public void setBowledAtBall(int bowledAtBall) {
        this.bowledAtBall = bowledAtBall;
    }

    public Player getWicketTakenBy() {
        return wicketTakenBy;
    }

    public void setWicketTakenBy(Player wicketTakenBy) {
        this.wicketTakenBy = wicketTakenBy;
    }


}
