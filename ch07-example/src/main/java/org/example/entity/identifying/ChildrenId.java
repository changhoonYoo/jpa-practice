package org.example.entity.identifying;

import java.io.Serializable;

//자식 ID
public class ChildrenId implements Serializable {

    private String parent;
    private String childid;

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
