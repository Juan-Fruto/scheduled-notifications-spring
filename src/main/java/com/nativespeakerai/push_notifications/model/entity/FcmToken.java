package com.nativespeakerai.push_notifications.model.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "tcm_token")
@NoArgsConstructor
public class FcmToken implements Serializable {

    @Id
    @Column(name = "tcm_token")
    private String tcmToken;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
