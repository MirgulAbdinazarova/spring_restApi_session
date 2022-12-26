package com.example.spring_restapi_session.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="roles")
@Getter
@Setter@NoArgsConstructor
public class Role {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String roleName;

    @ManyToMany(targetEntity = User.class,mappedBy = "roles",cascade =CascadeType.ALL )
    private List<User>users;
}
