package com.example.helpcs.domain.posts;

import com.example.helpcs.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {
    List<Posts> findByUserId(String userId);
    Posts findByQuestionTitleAndAnswer(String questionTitle, String answer);
}
