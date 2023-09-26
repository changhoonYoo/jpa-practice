package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@IdClass(ParentId.class)
@NoArgsConstructor
@Getter
@Setter
public class Parent {

//    @Id
//    @Column(name = "PARENT_ID1")
//    private String id1;

//    @Id
//    @Column(name = "PARENT_ID2")
//    private String id2;

    @EmbeddedId
    private ParentId id;

    private String name;
}
