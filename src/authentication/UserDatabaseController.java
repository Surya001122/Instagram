package authentication;

import user.User;
import userInterface.UIHandler;

import java.util.ArrayList;

public class UserDatabaseController {
    private final UIHandler uiHandler = new UIHandler();
    private final UserDatabase userDatabase = UserDatabase.getInstance();
    public User loginUser(){
        String userId = uiHandler.getUserId();
        String password = uiHandler.getUserPassword();
        if(userDatabase.isLoginInfoCorrect(userId, password)){
            uiHandler.displayUserLoggedInMessage();
            return getUser(userId);
        }
        else{
            uiHandler.displayUserNotLoggedInMessage();
            return null;
        }
    }
    public void addUserLoginInfo(User user){
        userDatabase.addUserLoginInfo(user);
    }
    public ArrayList<User> getUsers() {
        return userDatabase.getUsers();
    }
    public User getUser(String userId){
        return userDatabase.getOtherUser(userId);
    }
}
