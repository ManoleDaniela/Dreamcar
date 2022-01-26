package dreamcar.service;

import dreamcar.domain.ComponentRequests;
import dreamcar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dreamcar.domain.User;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loginUser(String name, String password){
        return userRepository.login(name, password);
    }

    public Optional<User> getById (Long id){
        return userRepository.findById(id);
    }

}
