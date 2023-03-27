package controllers;

import db.DBManager;
import user.User;
import userInterface.UIHandler;

public interface ReactionController {
    DBManager dbManager = new DBManager();
    UIHandler uiHandler = new UIHandler();
    void addReaction(User fromUser,User toUser);
    void deleteReaction(User fromUser, User toUser);
    void viewReactions(User toUser);
}
