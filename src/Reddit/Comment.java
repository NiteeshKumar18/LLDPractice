package Reddit;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Comment {

    private final int commentId;
    private final String content;
    private final int userId;
    private final Instant createdAt;
    private Instant editedAt;
    private final List<Comment> replies;
    private List<Vote> votesList;


    public Comment(int commentId, String content, int userId, Instant createdAt) {
        this.commentId = commentId;
        this.content = content;
        this.userId = userId;
        this.createdAt = createdAt;
        this.replies = new ArrayList<>();
    }


    public int getScore() {
        int score = 0;
        for (Vote vote : votesList) {
            score += vote.getVoteType().equals(VoteType.UPVOTE) ? 1 : -1;
        }
        return score;
    }

    public int getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public int getUserId() {
        return userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getEditedAt() {
        return editedAt;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setEditedAt(Instant editedAt) {
        this.editedAt = editedAt;
    }

    public void setVotesList(List<Vote> votesList) {
        this.votesList = (votesList != null) ? new java.util.ArrayList<>(votesList) : new java.util.ArrayList<>();
    }


    public void addVote(Vote vote) {
        if (this.votesList == null) {
            this.votesList = new java.util.ArrayList<>();
        }
        this.votesList.add(vote);
    }


}
