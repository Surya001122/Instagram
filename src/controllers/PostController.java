package controllers;
import db.DBManager;
import user.User;
import userInterface.UIHandler;

public interface PostController {
    UIHandler uiHandler = new UIHandler();
    DBManager dbManager = new DBManager();
    void addPost(User user);
    void deletePost(User user);
    boolean viewPost(User user);
}
