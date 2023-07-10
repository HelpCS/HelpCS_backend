package com.example.helpcs.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "userid")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; // 유저에게 고유하게 부여되는 id.

    @Column(nullable = false)
    private String username; // 유저의 이름

    @Column(nullable = false)
    private String userId; // 유저의 아이디

    @Column(nullable = false)
    private String password; // 패스워드
}
