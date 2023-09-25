package jpabook.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberTwo {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long Id;

    private String username;

    public MemberTwo(String username) {
        this.username = username;
    }
}
