package com.example.helpcs.web.dto;

import com.example.helpcs.domain.posts.Posts;

public class PostsListResponseDto {
    private Long id;
    private String questionTitle;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.questionTitle = entity.getQuestionTitle();
    }
}
