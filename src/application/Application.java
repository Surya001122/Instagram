package application;


import authentication.UserDatabaseController;
import controllers.*;
import db.DBManager;
import postCollections.MyPosts;
import user.User;
import userInterface.UIHandler;

public class Application {
    PostController photoPostController = new PhotoController();
    PostController videoPostController = new VideoController();
    ReactionController likeController = new LikeController();
    ReactionController commentController = new CommentController();
    UIHandler uiHandler = new UIHandler();
    DBManager dbManager = new DBManager();
    UserDatabaseController userDatabaseController = new UserDatabaseController();
    User user1 = new User("user1","user_1","1234567890","user@gmail.com","Employee","Test@123");
    MyPosts myPosts1 = new MyPosts();
    User user2 = new User("user2","user_2","1234567890","user@gmail.com","Employee","Test@123");
    MyPosts myPosts2 = new MyPosts();
    User user3 = new User("user3","user_3","1234567890","user@gmail.com","Employee","Test@123");
    MyPosts myPosts3 = new MyPosts();
    User user4 = new User("user4","user_4","1234567890","user@gmail.com","Employee","Test@123");
    MyPosts myPosts4 = new MyPosts();
    User user5 = new User("user5","user_5","1234567890","user@gmail.com","Employee","Test@123");
    MyPosts myPosts5 = new MyPosts();

    public void start(){
        dbManager.addUser(user1,myPosts1);
        dbManager.addUser(user2,myPosts2);
        dbManager.addUser(user3,myPosts3);
        dbManager.addUser(user4,myPosts4);
        dbManager.addUser(user5,myPosts5);
        userDatabaseController.addUserLoginInfo(user1);
        userDatabaseController.addUserLoginInfo(user2);
        userDatabaseController.addUserLoginInfo(user3);
        userDatabaseController.addUserLoginInfo(user4);
        userDatabaseController.addUserLoginInfo(user5);
        boolean run = true;
        while(run) {
            User user = userDatabaseController.loginUser();
            boolean bool = user != null;
            while (bool) {
                int choice = uiHandler.interactWithUser();
                switch (choice) {
                    case 1:
                        photoPostController.addPost(user);
                        break;
                    case 2:
                        photoPostController.deletePost(user);
                        break;
                    case 3:
                        photoPostController.viewPost(user);
                        break;
                    case 4:
                        videoPostController.addPost(user);
                        break;
                    case 5:
                        videoPostController.deletePost(user);
                        break;
                    case 6:
                        videoPostController.viewPost(user);
                        break;
                    case 7:
                        uiHandler.displayUsers(userDatabaseController.getUsers());
                        String userId = uiHandler.interactWithOtherUser();
                        User otherUser = userDatabaseController.getUser(userId);
                        boolean otherBool = otherUser != null;
                        boolean bool1 = photoPostController.viewPost(otherUser);
                        boolean bool2 = videoPostController.viewPost(otherUser);
                        while (otherBool) {
                            if(bool1 || bool2) {
                                int otherChoice = uiHandler.doOperationsForOtherUserPost();
                                switch (otherChoice) {
                                    case 1:
                                        likeController.addReaction(user,otherUser);
                                        break;
                                    case 2:
                                        commentController.addReaction(user,otherUser);
                                        break;
                                    case 3:
                                        likeController.deleteReaction(user,otherUser);
                                        break;
                                    case 4:
                                        commentController.deleteReaction(user,otherUser);
                                        break;
                                    case 5:
                                        photoPostController.viewPost(otherUser);
                                        videoPostController.viewPost(otherUser);
                                        likeController.viewReactions(otherUser);
                                        break;
                                    case 6:
                                        photoPostController.viewPost(otherUser);
                                        videoPostController.viewPost(otherUser);
                                        commentController.viewReactions(otherUser);
                                        break;
                                    case 7:
                                        otherBool = false;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            else {
                                break;
                            }
                        }
                        break;
                    case 8:
                        bool = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
