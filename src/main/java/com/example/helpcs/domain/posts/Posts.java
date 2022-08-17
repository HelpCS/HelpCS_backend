package com.example.helpcs.domain.posts;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Posts")
public class Posts  {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String Id;
    private String questionTitle;
    private String question;
    private String userId;
    private String answer;
    private String questionUrl;





}
