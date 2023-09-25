package jpabook.model.manytomany2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberEntity { //6.19 회원 코드

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;
    //역방향
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts;
}
