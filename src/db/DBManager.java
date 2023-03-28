package db;

import postCollections.MyPosts;
import user.User;

public class DBManager {
    private final Database database;

    public DBManager() {
        this.database = Database.getInstance();
    }
    public MyPosts getUserPostCollection(User user){
        return database.getUserPostsCollection(user);
    }
    public void addUser(User user,MyPosts myPosts){
        database.addUser(user,myPosts);
    }
}

