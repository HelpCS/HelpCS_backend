package com.example.helpcs.web.dto;

import com.example.helpcs.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostsSaveRequestDto {
    private Long id;
    private String questionTitle;
    private String question;
    private String questionUrl;
    private String answer;
    private String userId;




    public PostsSaveRequestDto(final Posts entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.questionTitle = entity.getQuestionTitle();
        this.question = entity.getQuestion();
        this.questionUrl = entity.getQuestionUrl();
        this.answer = entity.getAnswer();
    }

    public static Posts toEntity(final PostsSaveRequestDto dto){
        return  Posts.builder()
                .Id(dto.getId())
                .questionTitle(dto.getQuestionTitle())
                .question(dto.getQuestion())
                .questionUrl(dto.getQuestionUrl())
                .answer(dto.getAnswer())
                .userId(dto.getUserId())
                .build();
    }
}
