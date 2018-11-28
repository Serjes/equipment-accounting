package com.serjes.equiper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_FIN_RESP = "FIN_RESP";
    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_ENGINEER = "ENGINEER";
    public static final String ROLE_VIEWER = "VIEWER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    private String role;

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
