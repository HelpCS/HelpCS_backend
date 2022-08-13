package com.example.helpcs.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String solution;

    @Builder
    public PostsUpdateRequestDto( String solution){
        this.solution = solution;
    }
}
