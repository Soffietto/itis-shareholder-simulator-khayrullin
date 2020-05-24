package ru.kpfu.itis.shareholdersimulator.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.kpfu.itis.shareholdersimulator.entity.enums.Role;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@Accessors(chain = true)
public class User extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private char[] password;

    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;

}
