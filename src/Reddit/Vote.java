package Reddit;

public class Vote {

    private final int voteId;
    private final VoteType voteType;

    public Vote(int voteId, VoteType voteType) {
        this.voteId = voteId;
        this.voteType = voteType;
    }

    public int getVoteId() {
        return voteId;
    }

    public VoteType getVoteType() {
        return voteType;
    }
}
