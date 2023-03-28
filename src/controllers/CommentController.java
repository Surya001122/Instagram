package controllers;
import postCollections.MyPosts;
import postReaction.Comment;
import postReactionCollection.PostCommentsSection;
import post.Photo;
import post.Video;
import user.User;

import java.util.ArrayList;

public class CommentController implements ReactionController {
    @Override
    public void addReaction(User fromUser,User toUser) {
        MyPosts myPosts = dbManager.getUserPostCollection(toUser);
        if(myPosts!=null) {
            int postId = uiHandler.getPostId();
            PostCommentsSection commentSection = myPosts.getCommentSection(postId);
            if(commentSection!=null) {
                Comment comment = new Comment(fromUser, uiHandler.getCommentFromUser());
                commentSection.addComment(comment);
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
            PostCommentsSection commentSection = myPosts.getCommentSection(postId);
            if (commentSection != null) {
                Comment comment = commentSection.getComment(fromUser, uiHandler.getCommentId());
                if (comment != null) {
                    commentSection.deleteComment(comment);
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
                PostCommentsSection commentSection = myPosts.getCommentSection(postId);
                ArrayList<Comment> comments = commentSection.getPostComments();
                uiHandler.displayAllComments(comments);
            }if (video != null) {
                ArrayList<Video> videos = new ArrayList<>();

                videos.add(video);
                uiHandler.displayAllVideos(videos);
                PostCommentsSection commentSection = myPosts.getCommentSection(postId);
                ArrayList<Comment> comments = commentSection.getPostComments();
                uiHandler.displayAllComments(comments);
            }
            if(photo==null && video==null){
                uiHandler.displayNoPhotosMessage();
                uiHandler.displayNoVideosMessage();
            }
        }
    }
}
