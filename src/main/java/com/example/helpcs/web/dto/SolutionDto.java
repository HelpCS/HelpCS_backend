package com.example.helpcs.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolutionDto {
    private String userId;
    private String solution;
    private String questionTitle;
}
