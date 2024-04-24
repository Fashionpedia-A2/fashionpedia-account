package id.my.fashionpediaapiaccount.service;

import id.my.fashionpediaapiaccount.model.User;
import id.my.fashionpediaapiaccount.model.UserProfile;
import id.my.fashionpediaapiaccount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserProfile get(String username){
        User user = userRepository.getUser(username);
        UserProfile userProfile = user.getProfile();
        return userProfile;
    }

    @Override
    public boolean set(String phoneNumber, String address, String about) {
        return false;
    }


}
