package org.example.entity.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
@NoArgsConstructor
public class Album extends Item{

    private String artist;
}
