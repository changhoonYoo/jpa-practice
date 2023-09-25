package jpabook.model.manytomany2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@IdClass(MemberProductId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberProduct { //6.21 회원상품 엔티티 코드

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity member; //MemberProductId.memberEntity 와 연결

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product; //MemberProductId.productEntity 와 연결

    private int orderAmount;
}
