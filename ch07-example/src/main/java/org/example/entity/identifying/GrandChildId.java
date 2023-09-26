package org.example.entity.identifying;

import javax.persistence.Column;
import java.io.Serializable;

public class GrandChildId implements Serializable {

    private ChildrenId child; //GrandChild.child 매핑
    private String id; //GrandChild.id 매핑

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
