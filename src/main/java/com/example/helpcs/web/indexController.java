package com.example.helpcs.web;

import com.example.helpcs.domain.posts.Posts;
import com.example.helpcs.survice.posts.PostsService;
import com.example.helpcs.survice.solutions.SolutionsService;
import com.example.helpcs.web.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
@Slf4j
public class indexController {

    @Autowired
    private PostsService service;

    @Autowired
    private SolutionsService service2;
    @PostMapping("/save")
    public ResponseEntity<?> createPosts(
            @AuthenticationPrincipal String userId,
            @RequestBody PostsSaveRequestDto dto) {
        try {
            // (1) posts로 변환한다.
            Posts entity = PostsSaveRequestDto.toEntity(userId,dto);
            // (2) id를 null로 초기화 한다. 생성 당시에는 id가 없어야 하기 때문이다.
//            entity.builder().Id(null);
            // (3) userid 입력
//            entity.builder().userId(userId);

            // (4) 서비스를 이용해 Posts엔티티를 생성한다.
            List<Posts> entities = service.create(entity);

            // (5) 자바 스트림을 이용해 리턴된 엔티티 리스트를 PostsSaveRequestDto리스트로 변환한다.

            List<PostsSaveRequestDto> dtos = entities.stream().map(PostsSaveRequestDto::new).collect(Collectors.toList());

            // (6) 변환된 PostsSaveRequestDto리스트를 이용해ResponseDTO를 초기화한다.
            PostsResponseDto<PostsSaveRequestDto> response = PostsResponseDto.<PostsSaveRequestDto>builder().data(dtos).build();

            // (7) ResponseDTO를 리턴한다.
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // (8) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.

            String error = e.getMessage();
            PostsResponseDto<Posts> response = PostsResponseDto.<Posts>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> retrievePostsList(
            @AuthenticationPrincipal String userId) {
        System.out.println("UserID : " + userId);
        // (1) 서비스 메서드의 retrieve메서드를 사용해 posts리스트를 가져온다
        List<Posts> entities = service.retrieve(userId);

        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 PostsSaveRequestDto리스트로 변환한다.
        List<PostsSaveRequestDto> dtos = entities.stream().map(PostsSaveRequestDto::new).collect(Collectors.toList());

        // (6) 변환된 PostsSaveRequestDto리스트를 이용해ResponseDTO를 초기화한다.
        PostsResponseDto<PostsSaveRequestDto> response = PostsResponseDto.<PostsSaveRequestDto>builder().data(dtos).build();

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok(response);
    }


    @PutMapping
    public ResponseEntity<?> updatePosts(@AuthenticationPrincipal String userId,
                                        @RequestBody PostsSaveRequestDto dto) {
        // (1) dto를 entity로 변환한다.
        Posts entity = PostsSaveRequestDto.toEntity(userId,dto);
        log.info(userId);
        // (2) id를 userId 초기화 한다.
//        entity.builder().userId(userId);
        // (3) 서비스를 이용해 entity를 업데이트 한다.
        List<Posts> entities = service.update(entity);

        // (4) 자바 스트림을 이용해 리턴된 엔티티 리스트를 PostsSaveRequestDto리스트로 변환한다.
        List<PostsSaveRequestDto> dtos = entities.stream().map(PostsSaveRequestDto::new).collect(Collectors.toList());

        // (5) 변환된 PostsSaveRequestDto리스트를 이용해ResponseDTO를 초기화한다.
        PostsResponseDto<PostsSaveRequestDto> response = PostsResponseDto.<PostsSaveRequestDto>builder().data(dtos).build();

        // (6) ResponseDTO를 리턴한다.
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deletePosts(
            @AuthenticationPrincipal String userId,
            @RequestBody PostsSaveRequestDto dto) {
        try {
            // (1) posts로 변환한다.
            Posts entity = PostsSaveRequestDto.toEntity(userId,dto);

            // (2) 임시 유저 아이디를 설정 해 준다.
//            entity.builder().userId(userId);


            // (3) 서비스를 이용해 entity를 삭제 한다.
            List<Posts> entities = service.delete(entity);

            // (4) 자바 스트림을 이용해 리턴된 엔티티 리스트를 PostsSaveRequestDto리스트로 변환한다.
            List<PostsSaveRequestDto> dtos = entities.stream().map(PostsSaveRequestDto::new).collect(Collectors.toList());

            // (5) 변환된 PostsSaveRequestDto리스트를 이용해ResponseDTO를 초기화한다.
            PostsResponseDto<PostsSaveRequestDto> response = PostsResponseDto.<PostsSaveRequestDto>builder().data(dtos).build();

            // (6) ResponseDTO를 리턴한다.
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // (8) 혹시 예외가 나는 경우 dto대신 error에 메시지를 넣어 리턴한다.
            String error = e.getMessage();
            PostsResponseDto<PostsSaveRequestDto> response = PostsResponseDto.<PostsSaveRequestDto>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    @PostMapping("/{getQuestionTitle}")
    public ResponseEntity<?> OX(@PathVariable String getQuestionTitle,@RequestBody SolutionDto solutionDto) {
        Posts solutions = service2.oxquiz(getQuestionTitle,solutionDto.getSolution());

        if(solutions != null) {
            SolutionsResponseDTO solutionsResponseDTO = SolutionsResponseDTO.builder()
                    .error("틀렸습니다.")
                    .build();
            return ResponseEntity
                    .badRequest()
                    .body(solutionsResponseDTO);
        } else {
            final SolutionDto solutionDto1 = SolutionDto.builder()
                    .solution(solutionDto.getSolution())
                    .questionTitle(getQuestionTitle)
                    .userId(solutionDto.getUserId())
                    .build();
            return ResponseEntity.ok().body(solutionDto1);

        }
    }


}
