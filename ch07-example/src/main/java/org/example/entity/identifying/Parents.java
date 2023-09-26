package org.example.entity.identifying;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Parents {

    @Id
    @Column(name = "PARENT_ID")
    private String id;
    private String name;
}
