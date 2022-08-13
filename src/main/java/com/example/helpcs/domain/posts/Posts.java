package com.example.helpcs.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(length = 500, nullable = false)
    private String questionTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question;

    private String userId;
    private String answer;

    private String questionUrl;


    @Builder
    public Posts(String questionTitle, String question, String answer, String questionUrl,String userId){
        this.questionTitle = questionTitle;
        this.question = question;
        this.answer = answer;
        this.questionUrl = questionUrl;
        this.userId = userId;
    }



}
