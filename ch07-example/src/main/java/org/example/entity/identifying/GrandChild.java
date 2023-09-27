package org.example.entity.identifying;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//손자
@Entity
//@IdClass(GrandChildId.class)
@NoArgsConstructor
@Getter
@Setter
public class GrandChild {

    @EmbeddedId
    private GrandChildId id;

//    @Id
    @MapsId("childId") //GrandChildId.childId 매핑
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private Children child;

//    @Id
//    @Column(name = "GRANDCHILD_ID")
//    private String id;

    private String name;
}
