package id.my.fashionpediaapiaccount;

import id.my.fashionpediaapiaccount.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.addUser("Alicia", "jrLzrEPyYRlkyrCurECErrrIZxz");
        userRepository.addUser("Bob", "IFuSJRfCEzzrSDgv");
        userRepository.addUser("Charlie", "CRrIvYziZVtyTc");

    }
}
