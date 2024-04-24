package id.my.fashionpediaapiaccount.service;

import id.my.fashionpediaapiaccount.model.UserProfile;

public interface ProfileService {
    UserProfile get(String username);
    boolean set(String phoneNumber, String address, String about);
}
