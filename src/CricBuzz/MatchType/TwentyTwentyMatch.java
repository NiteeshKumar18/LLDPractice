package CricBuzz.MatchType;

public class TwentyTwentyMatch implements MatchTypeInterface {
    @Override
    public int getOversSize() {
        return 20;
    }

    @Override
    public int oversRestrictedForOneBowler() {
        return 4;
    }
}
