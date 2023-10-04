package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;

//    @ManyToOne(fetch = FetchType.EAGER) //fetch = FetchType.EAGER : 즉시 로딩
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
//    @JoinColumn(name = "TEAM_ID", nullable = false) //nullable = false : JPA 외부 조인 대신에 내부 조인 사용
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}
