package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;

    private String password;
    @Column(unique = true)
    private String email;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private List<Role> roles;
    private Boolean activate;
    @OneToMany
    @JoinColumn(name ="user")
    private List<History> history;
    @OneToMany
    @JoinColumn(name ="user")
    private List<Reservation> reservations;
    private String address;
    @OneToMany
    @JoinColumn(name ="user")
    private List<Favorite> favorites;

    public User(String userName, String password, String email,Boolean activate, List<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.activate = activate;
    }
}
