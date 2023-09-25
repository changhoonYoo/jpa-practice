package jpabook.model.manytomany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

    @ManyToMany(mappedBy = "products") //역방향 추가
    private List<MemberMTM> members;
}
