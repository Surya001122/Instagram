package posts;
import postSection.MyCommentSection;
import postSection.MyLikeSection;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Post {
    static int pId = 1;
    private final int postId;
    private int totalLikes;
    private int totalComments;
    private final MyCommentSection myComments;
    private final MyLikeSection myLikes;
    private final String caption;
    private final String postTime;

    public Post(String caption) {
        this.postId = pId++;
        totalLikes = 0;
        totalComments = 0;
        myComments = new MyCommentSection();
        myLikes = new MyLikeSection();
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

    public MyCommentSection getMyCommentSection() {
        return myComments;
    }

    public MyLikeSection getMyLikeSection() {
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
