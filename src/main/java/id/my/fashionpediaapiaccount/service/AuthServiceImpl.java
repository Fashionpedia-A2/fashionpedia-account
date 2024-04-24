package id.my.fashionpediaapiaccount.service;

import id.my.fashionpediaapiaccount.model.Encryptor;
import id.my.fashionpediaapiaccount.model.User;
import id.my.fashionpediaapiaccount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean login(String username, String password) {
        User supposedUser = userRepository.getUser(username);
        return supposedUser != null &&
                toCipher(password).equals(supposedUser.getPassword());
    }

    @Override
    public void register(String username, String password) {
        userRepository.addUser(username, toCipher(password));
    }

    private String toCipher(String password) {
        Encryptor encryptor = new Encryptor();
        return encryptor.encrypt(password);
    }
}
