package id.my.fashionpediaapiaccount.model;

import id.my.fashionpediaapiaccount.model.UserProfile;

public class User {
    private final String username;
    private final String password;

    private final UserProfile profile;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = new UserProfile(username);
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public UserProfile getProfile() { return profile; }
}
