package CricBuzz.Team.Scorecards;

public class BowlingScorecard {

    private int noOfOversBowled;

    private int runsGiven;

    private int wicketsTaken;


    public int getNoOfOversBowled() {
        return this.noOfOversBowled;
    }

    public void setNoOfOversBowled(int noOfOversBowled) {
        this.noOfOversBowled = this.noOfOversBowled + noOfOversBowled;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = this.wicketsTaken + wicketsTaken;
    }
}
