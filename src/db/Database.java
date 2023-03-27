package db;
import post.MyPosts;
import user.User;
import java.util.HashMap;
class Database {
    private static Database database = null;
    private final HashMap<User, MyPosts> userPosts = new HashMap<>();

    private Database(){}

    static Database getInstance(){
        if(database == null){
            database = new Database();
        }
        return database;
    }
    MyPosts getUserPostsCollection(User user1){
        if(userPosts.containsKey(user1)) {
            for (User user2 : userPosts.keySet()) {
                if (user1.equals(user2)) {
                    return userPosts.get(user2);
                }
            }
        }
        return null;
    }
    public void addUser(User user,MyPosts myPosts){
        userPosts.put(user,myPosts);
    }
}
