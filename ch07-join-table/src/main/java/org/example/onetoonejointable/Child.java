package org.example.onetoonejointable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@NoArgsConstructor
@Setter
@Getter
public class Child {

    @Id
    @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

    //양방향 매핑을 위한 코드 추가
    @OneToOne(mappedBy = "child")
    private Parent parent;
}
