package CricBuzz;

import CricBuzz.Innings.Innings;
import CricBuzz.MatchType.MatchTypeInterface;
import CricBuzz.Team.Team;

import java.util.List;

public class Match {

    private  final int matchId;
    private  final String location;

    private Team teamA;

    private Team teamB;

    private MatchTypeInterface matchTypeInterface;

    private Team teamWon;

    private final List<String> umpires;

    private Team tossWon;

    private Innings innings1;

    private Innings innings2;


    public Match(int matchIdLocal, String locationLocal, List<String> umpiresLocal){
        this.matchId = matchIdLocal;
        this.location = locationLocal;
        this.umpires = umpiresLocal;
    }




}
