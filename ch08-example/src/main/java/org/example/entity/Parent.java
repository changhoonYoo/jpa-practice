package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_seq")
    @SequenceGenerator(name = "parent_seq", sequenceName = "parent_sequence", allocationSize = 1)
    private Long id;

//    @OneToMany(mappedBy = "parent")
//    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST) //영속성 전이 활성화
//    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE) //영속성 전이 자식 같이 삭제
    @OneToMany(mappedBy = "parent", orphanRemoval = true, cascade = CascadeType.ALL) //고아객체(연관관계가 끊어진 자식 엔티티) 같이 제거
    private List<Child> children = new ArrayList<>();
}
