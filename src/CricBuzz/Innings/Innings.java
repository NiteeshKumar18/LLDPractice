package CricBuzz.Innings;

import CricBuzz.MatchType.MatchTypeInterface;
import CricBuzz.Team.Team;

import java.util.ArrayList;
import java.util.List;

public class Innings {

    private final int inningsId;
    private final Team bowlingTeam;

    private final Team battingTeam;

    private List<Overs> overs = new ArrayList();

    private MatchTypeInterface matchType;


    public Innings(int id, Team bowlingTeamLocal, Team battingTeamLocal) {
        this.bowlingTeam = bowlingTeamLocal;
        this.battingTeam = battingTeamLocal;
        this.inningsId = id;
    }


    public void startInnings() {
        int noOfOvers = matchType.getOversSize();
        for (int i = 0; i < noOfOvers; i++) {
            Overs over = new Overs(i);
            boolean won = over.playOver(bowlingTeam, battingTeam, bowlingTeam.getTotalRuns());
            if (won) {
                break;
            }
        }
    }
}
