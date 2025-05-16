package CricBuzz.MatchType;

public class OneDayMatch implements MatchTypeInterface {
    @Override
    public int getOversSize() {
        return 50;
    }

    @Override
    public int oversRestrictedForOneBowler() {
        return 10;
    }
}
