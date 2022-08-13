package com.example.helpcs.web.dto;

import com.example.helpcs.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String questionTitle;
    private String question;
    private String questionUrl;
    private String answer;

    private String userId;


    @Builder
    public PostsSaveRequestDto(String questionTitle, String question, String questionUrl, String answer,String userId){
        this.questionTitle = questionTitle;
        this.question = question;
        this.questionUrl = questionUrl;
        this.answer = answer;
        this.userId = userId;
    }

    public Posts toEntity(){
        return  Posts.builder()
                .questionTitle(questionTitle)
                .question(question)
                .questionUrl(questionUrl)
                .answer(answer)
                .userId(userId)
                .build();
    }
}
