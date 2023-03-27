package user;

public class User {
    private final String name;
    private final String userName;
    private final String phoneNumber;
    private final String emailId;
    private final String bio;
    private final String password;
    private final int totalFollowers;
    private final int totalFollowing;

    public User(String name, String userName, String phoneNumber, String emailId, String bio, String password) {
        this.name = name;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.bio = bio;
        this.password = password;
        this.totalFollowers = 0;
        this.totalFollowing = 0;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getBio() {
        return bio;
    }

    public int getTotalFollowers() {
        return totalFollowers;
    }

    public int getTotalFollowing() {
        return totalFollowing;
    }
    public String getPassword(){
        return password;
    }

}
