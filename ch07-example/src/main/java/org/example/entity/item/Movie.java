package org.example.entity.item;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@NoArgsConstructor
public class Movie extends Item{

    private String director;
    private String actor;
}
