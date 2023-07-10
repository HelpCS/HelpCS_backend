package com.example.helpcs.domain.posts;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "Posts")
public class Posts  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String questionTitle;
    private String question;
    private String userId;
    private String answer;
    private String questionUrl;





}
