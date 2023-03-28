package post;
import postReactionCollection.PostCommentsSection;
import postReactionCollection.PostLikesSection;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Post {
    static int pId = 1;
    private final int postId;
    private int totalLikes;
    private int totalComments;
    private final PostCommentsSection myComments;
    private final PostLikesSection myLikes;
    private final String caption;
    private final String postTime;

    public Post(String caption) {
        this.postId = pId++;
        totalLikes = 0;
        totalComments = 0;
        myComments = new PostCommentsSection();
        myLikes = new PostLikesSection();
        this.caption = caption;
        postTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    public int getPostId() {
        return postId;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getTotalComments() {
        return totalComments;
    }

    public String getCaption() {
        return caption;
    }

    public String getPostTime() {
        return postTime;
    }

    public PostCommentsSection getMyCommentSection() {
        return myComments;
    }

    public PostLikesSection getMyLikeSection() {
        return myLikes;
    }
    public void addLikeCount(){
        totalLikes++;
    }
    public void removeLikeCount(){
        totalLikes--;
    }
    public void addCommentCount(){
        totalComments++;
    }
    public void removeCommentCount(){
        totalComments--;
    }
}
