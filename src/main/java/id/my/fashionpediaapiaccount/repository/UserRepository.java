package id.my.fashionpediaapiaccount.repository;

import id.my.fashionpediaapiaccount.model.User;

public interface UserRepository {
    void addUser(String username, String password);
    User getUser(String username);
}
