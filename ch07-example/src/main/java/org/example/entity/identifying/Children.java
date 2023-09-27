package org.example.entity.identifying;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@IdClass(ChildrenId.class)
@NoArgsConstructor
@Setter
@Getter
public class Children {

    //@IdClass와 식별 관계
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "PARENT_ID")
//    public Parents parent;
//
//    @Id
//    @Column(name = "CHILD_ID")
//    private String childId;

    @EmbeddedId
    private ChildrenId id;

    @MapsId("parentId") //ChildrenId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parents parent;

    private String name;
}
