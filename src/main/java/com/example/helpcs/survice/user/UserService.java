package com.example.helpcs.survice.user;

import com.example.helpcs.domain.user.User;
import com.example.helpcs.domain.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(final User user) {
        if(user == null || user.getUserId() == null ) {
            throw new RuntimeException("Invalid arguments");
        }
        final String userId = user.getUserId();
        if(userRepository.existsByUserId(userId)) {
            log.warn("userId already exists {}", userId);
            throw new RuntimeException("userId already exists");
        }

        return userRepository.save(user);
    }

    public User getByCredentials(final String userId, final String password, final PasswordEncoder encoder) {
        final User originalUser = userRepository.findByUserId(userId);

        // matches 메서드를 이용해 패스워드가 같은지 확인
        if(originalUser != null && encoder.matches(password, originalUser.getPassword())) {
            return originalUser;
        }
        return null;
    }
}