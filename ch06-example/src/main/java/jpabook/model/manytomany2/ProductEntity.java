package jpabook.model.manytomany2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductEntity {
    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;
}
