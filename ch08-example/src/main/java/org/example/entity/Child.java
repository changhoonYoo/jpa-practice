package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_seq")
    @SequenceGenerator(name = "child_seq", sequenceName = "child_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Parent parent;
}

