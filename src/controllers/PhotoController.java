package controllers;
import postCollections.MyPosts;
import post.Photo;
import user.User;

import java.util.ArrayList;

public class PhotoController implements PostController {
    @Override
    public void addPost(User user) {
        Photo photo = new Photo(uiHandler.getCaptionFromUser(), uiHandler.getPostContentFromUser());
        MyPosts myPosts = dbManager.getUserPostCollection(user);
        if(myPosts!=null){
            myPosts.addPhoto(photo);
            uiHandler.displayPostUploadedMessage();
        }
    }
    @Override
    public void deletePost(User user) {
        viewPost(user);
        MyPosts myPosts = dbManager.getUserPostCollection(user);
        if(myPosts!=null && !myPosts.getPhotosCollection().isEmpty()) {
            int postId = uiHandler.getPostId();
            Photo photo = myPosts.getPhoto(postId);
            if(photo != null){
                myPosts.deletePhoto(photo);
                uiHandler.displayPostDeletedMessage();
            }
            else {
                uiHandler.displayNoPhotosMessage();
            }
        }
    }
    @Override
    public boolean viewPost(User user){
        MyPosts myPosts = dbManager.getUserPostCollection(user);
        if(myPosts!=null) {
            ArrayList<Photo> photos = myPosts.getPhotosCollection();
            if(!photos.isEmpty()){
                uiHandler.displayAllPhotos(photos);
                return true;
            }
            else{
                uiHandler.displayNoPhotosMessage();
                return false;
            }
        }
        return false;
    }
}
