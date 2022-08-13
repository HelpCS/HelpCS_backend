package com.example.helpcs.web.dto;

import com.example.helpcs.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String questionTitle;
    private String question;
    private String questionUrl;
    private String answer;

    private String userId;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.questionTitle = entity.getQuestionTitle();
        this.question = entity.getQuestion();
        this.answer = entity.getAnswer();
        this.questionUrl = entity.getQuestionUrl();
        this.userId = entity.getUserId();
    }
}
