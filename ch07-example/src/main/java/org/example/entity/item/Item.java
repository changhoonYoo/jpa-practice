package org.example.entity.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) //조인 전략
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //단일 테이블 전략
@DiscriminatorColumn(name = "DTYPE")
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int price;
}
