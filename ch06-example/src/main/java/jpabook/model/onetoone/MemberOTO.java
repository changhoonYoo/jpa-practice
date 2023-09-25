package jpabook.model.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Table(name = "MEMBER_OTO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberOTO { // 6.10 일대일 주 테이블에 외래 키. 단방향 예제 코드

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

}
