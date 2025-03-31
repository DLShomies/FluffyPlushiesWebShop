package com.dlshomies.fluffyplushies.entity;

import com.dlshomies.fluffyplushies.util.StrongPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class User extends BaseEntity {

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Column(unique = true)
    @Email
    private String email;

    @NotNull
    private int phone;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @StrongPassword
    private String password;
}
