package com.example.helpcs.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);
    Boolean existsByUserId(String userId);
    User findByUserIdAndPassword(String userId, String password);

}