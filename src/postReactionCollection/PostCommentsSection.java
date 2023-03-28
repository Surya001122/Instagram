package postReactionCollection;
import postReaction.Comment;
import user.User;

import java.util.ArrayList;


public class PostCommentsSection {
    ArrayList<Comment> postComments;

    public PostCommentsSection() {
        this.postComments = new ArrayList<>();
    }

    public ArrayList<Comment> getPostComments() {
        return postComments;
    }

    public void addComment(Comment comment) {
        postComments.add(comment);
    }
    public void deleteComment(Comment comment) {
        postComments.remove(comment);
    }

    public Comment getComment(User user, int id) {
        for(Comment comment : postComments){
            if(comment.getReactionBy().equals(user) && comment.getReactionId() == id){
                return comment;
            }
        }
        return null;
    }

}
