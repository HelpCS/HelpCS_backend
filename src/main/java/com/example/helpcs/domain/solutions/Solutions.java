package com.example.helpcs.domain.solutions;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "Solutions")
public class Solutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; // 유저에게 고유하게 부여되는 id.

    @Column(nullable = false)
    private String solution;
    @Column(nullable = false)
    private String userId; // 유저의 아이디

    @Column(nullable = false)
    private String questionTitle;

    private String questionUrl;
}
