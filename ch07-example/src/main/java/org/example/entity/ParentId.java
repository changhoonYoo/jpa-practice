package org.example.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable //추가
@NoArgsConstructor
public class ParentId implements Serializable {

    @Column(name = "PARENT_ID1") //추가
    private String id1;
    @Column(name = "PARENT_ID2") //추가
    private String id2;

    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
