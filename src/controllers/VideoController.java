package controllers;
import post.MyPosts;
import posts.Video;
import user.User;
import java.util.ArrayList;


public class VideoController implements PostController {

    @Override
    public void addPost(User user) {
        Video video = new Video(uiHandler.getCaptionFromUser(), uiHandler.getPostContentFromUser());
        MyPosts myPosts = dbManager.getUserPostCollection(user);
        if(myPosts!=null){
            myPosts.addVideo(video);
            uiHandler.displayPostUploadedMessage();
        }
    }

    @Override
    public void deletePost(User user) {
        viewPost(user);
        MyPosts myPosts = dbManager.getUserPostCollection(user);
        if(myPosts!=null && !myPosts.getVideosCollection().isEmpty()) {
            int postId = uiHandler.getPostId();
            Video video = myPosts.getVideo(postId);
            if(video != null){
                myPosts.deleteVideo(video);
                uiHandler.displayPostDeletedMessage();
            }
            else {
                uiHandler.displayNoVideosMessage();

            }
        }
    }

    @Override
    public boolean viewPost(User user) {
        MyPosts myPosts = dbManager.getUserPostCollection(user);
        if(myPosts!=null) {
            ArrayList<Video> videos = myPosts.getVideosCollection();
            if(!videos.isEmpty()){
                uiHandler.displayAllVideos(videos);
                return true;
            }
            else{
                uiHandler.displayNoVideosMessage();
                return false;
            }
        }
        return false;
    }
}
