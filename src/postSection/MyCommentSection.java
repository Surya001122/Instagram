package postSection;
import postReaction.Comment;
import user.User;


public class MyCommentSection extends Section<Comment> {
    public MyCommentSection() {
        super();
    }

    @Override
    public void add(Comment comment) {
        postSection.add(comment);
    }

    @Override
    public void delete(Comment comment) {
        postSection.remove(comment);
    }


    @Override
    public Comment get(User user, int id) {
        for(Comment comment : postSection){
            if(comment.getReactionBy().equals(user) && comment.getReactionId() == id){
                return comment;
            }
        }
        return null;
    }

}
