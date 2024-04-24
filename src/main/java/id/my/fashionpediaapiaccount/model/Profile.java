package id.my.fashionpediaapiaccount.model;

public class Profile {
    private final String username;
    private final String password;
    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
