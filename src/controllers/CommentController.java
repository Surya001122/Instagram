package controllers;
import post.MyPosts;
import postReaction.Comment;
import postSection.MyCommentSection;
import posts.Photo;
import posts.Video;
import user.User;

import java.util.ArrayList;

public class CommentController implements ReactionController {
    @Override
    public void addReaction(User fromUser,User toUser) {
        MyPosts myPosts = dbManager.getUserPostCollection(toUser);
        if(myPosts!=null) {
            int postId = uiHandler.getPostId();
            MyCommentSection commentSection = myPosts.getCommentSection(postId);
            if(commentSection!=null) {
                Comment comment = new Comment(fromUser, uiHandler.getCommentFromUser());
                commentSection.add(comment);
                myPosts.addComment(postId);
                uiHandler.displayCommentAddedMessage();
            }
        }
        else{
            uiHandler.displayNoPhotosMessage();
            uiHandler.displayNoVideosMessage();
        }
    }

    @Override
    public void deleteReaction(User fromUser,User toUser) {
        viewReactions(toUser);
        MyPosts myPosts = dbManager.getUserPostCollection(toUser);
        if(myPosts!=null && (!myPosts.getPhotosCollection().isEmpty() || !myPosts.getVideosCollection().isEmpty())) {
            int postId = uiHandler.getPostId();
            MyCommentSection commentSection = myPosts.getCommentSection(postId);
            if (commentSection != null) {
                Comment comment = commentSection.get(fromUser, uiHandler.getCommentId());
                if (comment != null) {
                    commentSection.delete(comment);
                    myPosts.removeComment(postId);
                    uiHandler.displayCommentDeletedMessage();
                }
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
                MyCommentSection commentSection = myPosts.getCommentSection(postId);
                ArrayList<Comment> comments = commentSection.getPostSection();
                uiHandler.displayAllComments(comments);
            }if (video != null) {
                ArrayList<Video> videos = new ArrayList<>();

                videos.add(video);
                uiHandler.displayAllVideos(videos);
                MyCommentSection commentSection = myPosts.getCommentSection(postId);
                ArrayList<Comment> comments = commentSection.getPostSection();
                uiHandler.displayAllComments(comments);
            }
            if(photo==null && video==null){
                uiHandler.displayNoPhotosMessage();
                uiHandler.displayNoVideosMessage();
            }
        }
    }
}
