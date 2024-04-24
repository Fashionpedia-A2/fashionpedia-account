package id.my.fashionpediaapiaccount.repository;

import id.my.fashionpediaapiaccount.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void addUser(String username, String password) {
        if (users.get(username) != null) return;
        users.put(username, new User(username, password));
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

}
