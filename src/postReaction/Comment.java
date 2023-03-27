package postReaction;
import user.User;
import java.util.ArrayList;

public class Comment extends PostReaction {
    private final String text;
    private int totalLikes; // not used
    private int totalReplyComments; // not used
    private ArrayList<Like> likesForComment; // not used
    private ArrayList<Comment> replyComments; // not used


    public Comment(User commentBy, String text) {
        super(commentBy);
        this.text = text;
        this.totalLikes = 0;
        this.totalReplyComments = 0;
        likesForComment = new ArrayList<>();
        replyComments = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

}
