package jpabook.model.manytomany2;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MemberProductId implements Serializable { //6.22 회원상품 식별자 클래스

    private String member;  //MemberProduct.member 와 연결
    private String product; //MemberProduct.product 와 연결


    //hashCode and equals


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
