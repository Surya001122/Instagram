package postReaction;

import user.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class PostReaction {
    static int reaction = 1;
    private final int reactionId;
    private final User reactionBy;
    private final String reactionTime;

    public PostReaction(User reactionBy) {
        this.reactionId = reaction++;
        this.reactionBy = reactionBy;
        this.reactionTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    public User getReactionBy() {
        return reactionBy;
    }

    public int getReactionId() {
        return reactionId;
    }
    public String getReactionTime() {
        return reactionTime;
    }
}
