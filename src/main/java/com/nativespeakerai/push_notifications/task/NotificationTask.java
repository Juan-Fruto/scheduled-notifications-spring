package com.nativespeakerai.push_notifications.task;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.nativespeakerai.push_notifications.dto.DeviceNotificationRequest;
import com.nativespeakerai.push_notifications.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.management.NotificationFilter;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

@Component
public class NotificationTask {

    private static final Logger log = LoggerFactory.getLogger(NotificationFilter.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final NotificationService notificationService;

    public NotificationTask(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @Scheduled(cron = "0 8 4 * * ?") // format = second minute hour day month day week
    public void sendNotificationTask(){
        try {
            DeviceNotificationRequest notification = new DeviceNotificationRequest();

            notification.setTitle("Time to practice");
            notification.setBody("Give you a chance to improve your english comunication");
            notification.setDeviceToken("eyK2D7bBREaivjYahlLrYw:APA91bGPRLHNKY4fD9a3bTA339o09udpU6WNTkBkDxvzhh8fs35vwyCPTvvsbcNrU-8oN26LtqpZYqyWzujwmp02Y-QXLypG8qVLDvMCHs7fxFkyiphGPlRo652lgbId1L9dz82iZzWW");

            notificationService.sendNotificationToDevice(notification);
        } catch (FirebaseMessagingException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

