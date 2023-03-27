package postSection;

import postReaction.Like;
import user.User;


public class MyLikeSection extends Section<Like> {

    public MyLikeSection() {super();}

    @Override
    public void add(Like like) {
        postSection.add(like);
    }

    @Override
    public void delete(Like like) {
        postSection.remove(like);
    }

    @Override
    public Like get(User user, int id) {
        for(Like like : postSection){
            if(like.getReactionBy().equals(user) && like.getReactionId() == id){
                return like;
            }
        }
        return null;
    }

}
