package id.my.fashionpediaapiaccount.model;

public class Agent {
    private final String username;
    private final String password;
    public Agent(String username, String password) {
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
