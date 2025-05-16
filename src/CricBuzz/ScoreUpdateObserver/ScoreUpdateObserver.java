package CricBuzz.ScoreUpdateObserver;

import CricBuzz.Innings.Balls;

public interface ScoreUpdateObserver {

    void updateBallDetails(Balls balls);
}
