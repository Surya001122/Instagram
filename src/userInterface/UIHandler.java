package userInterface;
import postReaction.Comment;
import postReaction.Like;
import post.Photo;
import post.Video;
import user.User;
import java.util.ArrayList;
import java.util.Scanner;

public class UIHandler {
    public int interactWithUser(){
        Scanner sc = new Scanner(System.in);
        boolean bool = false;
        int choice = 0;
        while (!bool) {
            System.out.println("\n\n\nEnter 1 to upload a photo\nEnter 2 to delete a photo\nEnter 3 to view your photos\nEnter 4 to upload a video\nEnter 5 to delete a video\nEnter 6 to view your videos\nEnter 7 to view all other users and see their posts\nEnter 8 to logout\nEnter your choice : ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 1 && choice <= 8) {
                    bool = true;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\nEnter valid choice...Please try again");
            }
        }
        return choice;
    }
    public String interactWithOtherUser(){
        Scanner sc = new Scanner(System.in);
        String userId;
        System.out.println("\n\n\nEnter the userID to view their posts : ");
        userId = sc.nextLine().trim();
        return userId;
    }
    public int doOperationsForOtherUserPost(){
        Scanner sc = new Scanner(System.in);
        boolean bool = false;
        int choice = 0;
        while (!bool) {
            System.out.print("\n\n\nEnter 1 to like the post\nEnter 2 to comment for the post\nEnter 3 to remove like for the post\nEnter 4 to remove comment for the post\nEnter 5 to view all likes for the post\nEnter 6 to view all comments for the post\nEnter 7 to go backEnter your choice : ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 1 && choice <= 7) {
                    bool = true;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\nEnter valid choice...Please try again");
            }
        }
        return choice;
    }
    public String getPostContentFromUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nUpload the post : ");
        return sc.nextLine().trim();
    }
    public String getCaptionFromUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nUpload the post caption: ");
        return sc.nextLine().trim();
    }
    public int getPostId(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the post Id: ");
        return Integer.parseInt(sc.nextLine().trim());
    }
    public void displayUsers(ArrayList<User> users){
        if(users.isEmpty()){
            System.out.println("No users...");
            return;
        }
        for(User user : users){
            System.out.println("\nName : "+user.getName()+"\nUserID : "+user.getUserName()+"\nBio : "+user.getBio()+"\nFollowers : "+user.getTotalFollowers()+"\nFollowing :"+user.getTotalFollowing());
        }
    }
    public String getCommentFromUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nType the comment for the post : ");
        return sc.nextLine().trim();
    }
    public void displayPostUploadedMessage(){
        System.out.println("\nPost uploaded successfully...");
    }
    public void displayCommentAddedMessage(){
        System.out.println("\nComment added successfully...");
    }
    public void displayLikeAddedMessage(){
        System.out.println("\nLike added successfully...");
    }
    public void displayPostDeletedMessage(){
        System.out.println("\nPost deleted successfully...");
    }
    public void displayCommentDeletedMessage(){
        System.out.println("\nComment deleted successfully...");
    }
    public void displayLikeDeletedMessage(){
        System.out.println("\nLike deleted successfully...");
    }

    public void displayNoVideosMessage() {
        System.out.println("\nNo videos...");

    }
    public void displayNoPhotosMessage() {
        System.out.println("\nNo photos...");

    }
    public void displayAllPhotos(ArrayList<Photo> photos){
        for(Photo photo : photos){
            System.out.println("\nPostID : "+photo.getPostId()+"\nPost Content: "+photo.getPhotoContent()+"\nCaption : "+photo.getCaption()+"\nTotal likes : "+photo.getTotalLikes()+"\nTotal comments : "+photo.getTotalComments()+"\nPosted time : "+photo.getPostTime()+"\nImage url : "+ photo.getImageUrl());
        }
    }
    public void displayAllVideos(ArrayList<Video> videos){
        for(Video video : videos){
            System.out.println("\nPostID : "+video.getPostId()+"\nPost Content: "+video.getVideoContent()+"\nCaption : "+video.getCaption()+"\nTotal likes : "+video.getTotalLikes()+"\nTotal comments : "+video.getTotalComments()+"\nPosted time : "+video.getPostTime()+"\nVideo duration : "+video.getDurationInSeconds()+"\nVideo url : "+video.getVideoUrl());
        }
    }

    public void displayUserLoggedInMessage() {
        System.out.println("\nUser logged in successfully");
    }
    public String getUserId(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your user Id to login: ");
        return sc.nextLine().trim();
    }
    public String getUserPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter your user password to login: ");
        return sc.nextLine().trim();
    }

    public void displayUserNotLoggedInMessage() {
        System.out.println("\nUser credentials is incorrect");

    }

    public void displayAllComments(ArrayList<Comment> comments) {
        for(Comment comment : comments){
            System.out.println("\nComment : "+comment.getText()+"\nComment Id : "+comment.getReactionId()+"\nComment by : "+comment.getReactionBy().getUserName()+"\nTime : "+comment.getReactionTime());
        }
    }
    public void displayAllLikes(ArrayList<Like> likes) {
        for(Like like : likes){
            System.out.println("\nLike Id : "+like.getReactionId()+"\nLiked by : "+like.getReactionBy().getUserName()+"\nTime : "+like.getReactionTime());
        }
    }

    public int getCommentId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the comment Id: ");
        return Integer.parseInt(sc.nextLine().trim());
    }
    public int getLikeId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the like Id: ");
        return Integer.parseInt(sc.nextLine().trim());
    }
}

