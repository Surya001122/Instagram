package postReactionCollection;

import postReaction.Like;
import user.User;

import java.util.ArrayList;


public class PostLikesSection {
    ArrayList<Like> postLikes;

    public PostLikesSection() {
        this.postLikes = new ArrayList<>();
    }

    public ArrayList<Like> getPostLikes() {
        return postLikes;
    }

    public void addLike(Like like) {
        postLikes.add(like);
    }

    public void deleteLike(Like like) {
        postLikes.remove(like);
    }
    public Like getLike(User user, int id) {
        for(Like like : postLikes){
            if(like.getReactionBy().equals(user) && like.getReactionId() == id){
                return like;
            }
        }
        return null;
    }

}
