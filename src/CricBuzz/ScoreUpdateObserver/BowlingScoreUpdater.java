package CricBuzz.ScoreUpdateObserver;

import CricBuzz.Innings.Balls;

public class BowlingScoreUpdater implements ScoreUpdateObserver {
    @Override
    public void updateBallDetails(Balls balls) {
        if (balls.getBallNo() == 6) {
            balls.getBowledBy().getBowlingScorecard().setNoOfOversBowled(1);
        }

        if (balls.isWicket()) {
            balls.getBowledBy().getBowlingScorecard().setWicketsTaken(1);
            return;
        }

        balls.getBowledBy().getBowlingScorecard().setRunsGiven(balls.getRunType().value);

    }
}
