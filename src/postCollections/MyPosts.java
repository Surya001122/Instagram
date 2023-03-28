package postCollections;
import postReactionCollection.PostCommentsSection;
import postReactionCollection.PostLikesSection;
import post.Photo;
import post.Video;
import java.util.ArrayList;

public class MyPosts{
    private final ArrayList<Photo> photos;
    private final ArrayList<Video> videos;

    public MyPosts() {
        this.photos = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    public void addPhoto(Photo photo){
        photos.add(photo);
    }
    public void deletePhoto(Photo photo){
        photos.remove(photo);
    }
    public void addVideo(Video video){
        videos.add(video);
    }
    public void deleteVideo(Video video){
        videos.remove(video);
    }
    public Video getVideo(int id){
        for(Video video : videos){
            if(video.getPostId() == id){
                return video;
            }
        }
        return null;
    }
    public Photo getPhoto(int id){
        for(Photo photo : photos){
            if(photo.getPostId() == id){
                return photo;
            }
        }
        return null;
    }
    public ArrayList<Photo> getPhotosCollection(){
        return new ArrayList<>(photos);
    }
    public ArrayList<Video> getVideosCollection(){
        return new ArrayList<>(videos);
    }
    public PostLikesSection getLikeSection(int postId){
        for(Video video : videos){
            if(video.getPostId() == postId){
                return video.getMyLikeSection();
            }
        }
        for(Photo photo : photos){
            if(photo.getPostId() == postId){
                return photo.getMyLikeSection();
            }
        }
        return null;
    }
    public PostCommentsSection getCommentSection(int postId){
        for(Video video : videos){
            if(video.getPostId() == postId){
                return video.getMyCommentSection();
            }
        }
        for(Photo photo : photos){
            if(photo.getPostId() == postId){
                return photo.getMyCommentSection();
            }
        }
        return null;
    }
    public void addLike(int id){
        Photo photo = getPhoto(id);
        if(photo!=null)
            photo.addLikeCount();
        Video video = getVideo(id);
        if(video!=null)
            video.addLikeCount();
    }
    public void addComment(int id){
        Photo photo = getPhoto(id);
        if(photo!=null)
            photo.addCommentCount();
        Video video = getVideo(id);
        if(video!=null)
            video.addCommentCount();
    }
    public void removeLike(int id){
        Photo photo = getPhoto(id);
        if(photo!=null)
            photo.removeLikeCount();
        Video video = getVideo(id);
        if(video!=null)
            video.removeLikeCount();
    }
    public void removeComment(int id){
        Photo photo = getPhoto(id);
        if(photo!=null)
            photo.removeCommentCount();
        Video video = getVideo(id);
        if(video!=null)
            video.removeCommentCount();
    }
}
