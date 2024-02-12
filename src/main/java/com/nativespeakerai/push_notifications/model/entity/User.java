package com.nativespeakerai.push_notifications.model.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private String userId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FcmToken> fcmTokens;
}
