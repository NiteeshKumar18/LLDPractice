package CricBuzz.ScoreUpdateObserver;

import CricBuzz.Innings.Balls;
import CricBuzz.Innings.RunType;

public class BattingScoreUpdater implements ScoreUpdateObserver {
    @Override
    public void updateBallDetails(Balls balls) {
        var batterScorecard = balls.getBattedBy().getBattingScorecard();
        batterScorecard.setNoOfBallsFaced(1);
        if (balls.isWicket()) {
            balls.getBattedBy().getBattingScorecard().setWicketTakenBy(balls.getBowledBy());
            balls.getBattedBy().getBattingScorecard().setBowledAtBall(balls.getBallNo());
        } else {
            batterScorecard.setRunsScored(balls.getRunType().value);
            if (balls.getRunType().value == 4) {
                batterScorecard.setNoOfFours(1);
            } else if (balls.getRunType().value == 6) {
                batterScorecard.setNoOfSixes(1);
            }
        }

    }
}
