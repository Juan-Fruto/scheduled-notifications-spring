package com.nativespeakerai.push_notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PushNotificationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PushNotificationsApplication.class, args);
    }

}
