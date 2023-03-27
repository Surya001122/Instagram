package controllers;
import post.MyPosts;
import postReaction.Like;
import postSection.MyLikeSection;
import posts.Photo;
import posts.Video;
import user.User;

import java.util.ArrayList;

public class LikeController implements ReactionController{
    @Override
    public void addReaction(User fromUser,User toUser) {
        MyPosts myPosts = dbManager.getUserPostCollection(toUser);
        if(myPosts!=null) {
            int postId = uiHandler.getPostId();
            MyLikeSection likeSection = myPosts.getLikeSection(postId);
            if (likeSection != null) {
                Like like = new Like(fromUser);
                likeSection.add(like);
                myPosts.addLike(postId);
                uiHandler.displayLikeAddedMessage();
            }
            else{
                uiHandler.displayNoPhotosMessage();
                uiHandler.displayNoVideosMessage();
            }
        }
    }

    @Override
    public void deleteReaction(User fromUser,User toUser) {
        viewReactions(toUser);
        MyPosts myPosts = dbManager.getUserPostCollection(toUser);
        if(myPosts!=null && (!myPosts.getPhotosCollection().isEmpty() || !myPosts.getVideosCollection().isEmpty())) {
            int postId = uiHandler.getPostId();
            MyLikeSection likeSection = myPosts.getLikeSection(postId);
            if (likeSection != null) {
                Like like = likeSection.get(fromUser, uiHandler.getLikeId());
                if (like != null) {
                    likeSection.delete(like);
                    myPosts.removeLike(postId);
                    uiHandler.displayLikeDeletedMessage();
                }
            }
            else {
                uiHandler.displayNoPhotosMessage();
                uiHandler.displayNoVideosMessage();
            }
        }

    }

    @Override
    public void viewReactions(User toUser) {
        MyPosts myPosts = dbManager.getUserPostCollection(toUser);
        if(myPosts!=null && (!myPosts.getPhotosCollection().isEmpty() || !myPosts.getVideosCollection().isEmpty())) {
            int postId = uiHandler.getPostId();
            Photo photo = myPosts.getPhoto(postId);
            Video video = myPosts.getVideo(postId);
            if (photo != null) {
                ArrayList<Photo> photos = new ArrayList<>();
                photos.add(photo);
                uiHandler.displayAllPhotos(photos);
                MyLikeSection likeSection = myPosts.getLikeSection(postId);
                ArrayList<Like> likes = likeSection.getPostSection();
                uiHandler.displayAllLikes(likes);
            }if (video != null) {
                ArrayList<Video> videos = new ArrayList<>();
                videos.add(video);
                uiHandler.displayAllVideos(videos);
                MyLikeSection likeSection = myPosts.getLikeSection(postId);
                ArrayList<Like> likes = likeSection.getPostSection();
                uiHandler.displayAllLikes(likes);
            }
            if(photo==null && video==null){
                uiHandler.displayNoPhotosMessage();
                uiHandler.displayNoVideosMessage();
            }
        }
    }
}
