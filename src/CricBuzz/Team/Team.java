package CricBuzz.Team;

import java.util.List;

public class Team {

    private final String id;

    private final String teamName;

    private final List<Player> allPlayers;

    private final List<Player> subsStitutePlayers;


    private final BattingController battingController;

    private final BowlingController bowlingController;

    private int totalRuns = -1;

    private boolean isWinner;

    public Team(String id, String teamName, List<Player> allPlayers, List<Player> subsStitutePlayers, BattingController battingController, BowlingController bowlingController) {
        this.id = id;
        this.teamName = teamName;
        this.allPlayers = allPlayers;
        this.subsStitutePlayers = subsStitutePlayers;
        this.battingController = battingController;
        this.bowlingController = bowlingController;
    }


    public BattingController getBattingController() {
        return battingController;
    }

    public BowlingController getBowlingController() {
        return bowlingController;
    }

    public int getTotalRuns() {
        return this.totalRuns;
    }

    public void setIsWinner(boolean bool){
        this.isWinner = bool;
    }


}
