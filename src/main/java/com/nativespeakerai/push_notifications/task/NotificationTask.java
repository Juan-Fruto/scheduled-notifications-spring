package com.nativespeakerai.push_notifications.task;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.nativespeakerai.push_notifications.dto.MultiDevicesNotificationRequest;
import com.nativespeakerai.push_notifications.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.management.NotificationFilter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Component
public class NotificationTask {

    private static final Logger log = LoggerFactory.getLogger(NotificationFilter.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final NotificationService notificationService;

    // constructor
    public NotificationTask(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(cron = "0 30 10 * * ?") // format = second minute hour day month day week
    public void sendNotificationTaskAllDevices() {
        try {
            MultiDevicesNotificationRequest notification = new MultiDevicesNotificationRequest();

            notification.setTitle("Time to practice!");
            notification.setBody("Give you a chance to improve your english communication");
            notification.setImageUrl("https://i.postimg.cc/ncdNrCNG/ranita-reloj.jpg");

            notificationService.sendMulticastNotification(notification);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }
}

