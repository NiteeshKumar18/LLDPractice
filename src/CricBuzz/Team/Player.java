package CricBuzz.Team;

import CricBuzz.Team.Scorecards.BattingScorecard;
import CricBuzz.Team.Scorecards.BowlingScorecard;

public class Player {

    private final int playerId;

    private final String name;

    private BowlingScorecard bowlingScorecard;

    private BattingScorecard battingScorecard;

    public Player(int playerId, String name) {
        this.playerId = playerId;
        this.name = name;
        this.bowlingScorecard = new BowlingScorecard();
        this.battingScorecard = new BattingScorecard();
    }

    public BowlingScorecard getBowlingScorecard(){
        return this.bowlingScorecard;
    }

    public BattingScorecard getBattingScorecard(){
        return this.battingScorecard;
    }
}
