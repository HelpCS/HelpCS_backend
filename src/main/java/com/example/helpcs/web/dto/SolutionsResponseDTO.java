package com.example.helpcs.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SolutionsResponseDTO<T> {
	private String error;
	private List<T> data;
}

