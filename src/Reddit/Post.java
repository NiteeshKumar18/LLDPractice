package Reddit;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private final String id;
    private final String title;
    private final String content;
    private final String userId;
    private final Instant createdAt;
    private final List<Vote> votesList;
    private final List<Comment> commentsList;


    public Post(String id, String title, String content, String userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createdAt = Instant.now();
        this.votesList = new ArrayList<>();
        this.commentsList = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        commentsList.add(comment);
    }

    public void addVote(Vote vote) {
        votesList.add(vote);
    }

    public int getScore() {
        int score = 0;
        for (Vote vote : votesList) {
            score += (vote.getVoteType() == VoteType.UPVOTE) ? 1 : -1;
        }
        return score;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public List<Vote> getVotesList() {
        // Return the unmodifiable view of the list
        return votesList;
    }

    public List<Comment> getCommentsList() {
        // Return the unmodifiable view of the list
        return commentsList;
    }


}
