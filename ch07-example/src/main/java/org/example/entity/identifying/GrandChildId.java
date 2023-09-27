package org.example.entity.identifying;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GrandChildId implements Serializable {

//    private ChildrenId child; //GrandChild.child 매핑
//    private String id; //GrandChild.id 매핑

    private ChildrenId childId; //@MapsId("childId") 로 매핑

    @Column(name = "GRANDCHILD_ID")
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
