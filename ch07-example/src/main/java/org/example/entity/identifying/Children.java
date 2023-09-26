package org.example.entity.identifying;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@IdClass(ChildrenId.class)
@NoArgsConstructor
@Setter
@Getter
public class Children {

    @Id
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parents parent;

    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    private String name;
}
