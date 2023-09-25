package jpabook.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamTwo {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<MemberTwo> members = new ArrayList<>();

    public TeamTwo(String name) {
        this.name = name;
    }
}
