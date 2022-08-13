package com.example.helpcs.web;

import com.example.helpcs.domain.posts.Posts;
import com.example.helpcs.domain.posts.PostsRepository;
import com.example.helpcs.survice.posts.PostsService;
import com.example.helpcs.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class indexController {

    @Autowired
    PostsRepository postsRepository;
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("posts",postsService.findAllDesc());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id ,String solution, Model model){
        Optional<Posts> selectedAnswer = postsRepository.findByAnswer(solution);
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        String errorMsg = null;
        if(selectedAnswer.isEmpty()){
            errorMsg = "오답입니다.";
            model.addAttribute("errorMsg", errorMsg);
        } else {
            errorMsg = "정답입니다.";
            model.addAttribute("errorMsg", errorMsg);
        }
        return "posts-update";
    }


}
