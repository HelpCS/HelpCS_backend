package com.example.helpcs.domain.solutions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Solutions")
public class Solutions {
    @Id
    private String Id; // 유저에게 고유하게 부여되는 id.

    @Column(nullable = false)
    private String solution;
    @Column(nullable = false)
    private String userId; // 유저의 아이디

    @Column(nullable = false)
    private String questionTitle;

    private String questionUrl;
}
