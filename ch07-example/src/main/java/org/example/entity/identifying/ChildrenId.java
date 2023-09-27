package org.example.entity.identifying;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
//자식 ID
public class ChildrenId implements Serializable {

    //@IdClass
//    private String parent; //Children.parent 매핑
//    private String childId; //Children.childId;

    private String parentId; //@MapsId("parentId") 로 매핑

    @Column(name = "CHILD_ID")
    private String id;

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
