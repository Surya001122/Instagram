package authentication;
import user.User;
import java.util.ArrayList;

class UserDatabase {
    private static UserDatabase userDatabase = null;
    private final ArrayList<User> users;
    private UserDatabase(){
        this.users = new ArrayList<>();
    }

    static UserDatabase getInstance(){
        if(userDatabase == null){
            userDatabase = new UserDatabase();
        }
        return userDatabase;
    }
    public boolean isLoginInfoCorrect(String userId,String password){
        for(User user : users) {
            if(user.getUserName().equals(userId) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public void addUserLoginInfo(User user){
        users.add(user);
    }
    public ArrayList<User> getUsers() {
        return new ArrayList<>(users);

    }
    public User getOtherUser(String userId){
        for (User user : users){
            if(user.getUserName().equals(userId)){
                return user;
            }
        }
        return null;
    }
}
