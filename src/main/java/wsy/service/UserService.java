package wsy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsy.model.Course;
import wsy.model.User;
import wsy.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
