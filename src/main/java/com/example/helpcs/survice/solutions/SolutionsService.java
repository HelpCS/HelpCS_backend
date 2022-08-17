package com.example.helpcs.survice.solutions;

import com.example.helpcs.domain.posts.Posts;
import com.example.helpcs.domain.posts.PostsRepository;
import com.example.helpcs.domain.solutions.Solutions;
import com.example.helpcs.domain.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class SolutionsService {
    @Autowired
    private PostsRepository postsRepository;
    public Posts oxquiz(final String questionTitle,final String solution) {

        final Posts postsAnswer = postsRepository.findByQuestionTitleAndAnswer(questionTitle,solution);

        // matches 메서드를 이용해 패스워드가 같은지 확인
        if(postsAnswer.equals(solution)) {
            return postsAnswer;
        }
        return null;
    }

}
