package id.my.fashionpediaapiaccount.model;

public class UserProfile {
    private final String username;
    private String phoneNumber;
    private String address;
    private String about;
    public UserProfile(String username) {
        this.username = username;
    }

    public void setProfile(String phoneNumber, String address, String about) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.about = about;
    }

    public String getUsername() {
        return username;
    }
}
