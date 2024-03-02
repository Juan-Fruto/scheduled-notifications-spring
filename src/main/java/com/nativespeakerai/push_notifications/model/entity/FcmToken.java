package com.nativespeakerai.push_notifications.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "fcm_token")
@NoArgsConstructor
@Getter
@Setter
public class FcmToken implements Serializable {

    @Id
    @Column(name = "fcm_token")
    private String fcmToken;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
