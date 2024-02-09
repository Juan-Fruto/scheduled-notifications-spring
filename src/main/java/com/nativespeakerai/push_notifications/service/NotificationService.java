package com.nativespeakerai.push_notifications.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.*;
import com.nativespeakerai.push_notifications.dto.DeviceNotificationRequest;
import com.nativespeakerai.push_notifications.dto.DevicesNotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {

    private final FirebaseApp firebaseApp;

    public void sendNotificationToDevice(DeviceNotificationRequest request) throws FirebaseMessagingException, ExecutionException, InterruptedException {
        Message fcmMessage = Message.builder()
                .setToken(request.getDeviceToken())
                .setNotification(
                        Notification.builder()
                                .setTitle(request.getTitle())
                                .setBody(request.getBody())
                                .setImage(request.getImageUrl())
                                .build()
                )
                .putAllData(request.getData())
                .build();

        String response = FirebaseMessaging.getInstance(firebaseApp).sendAsync(fcmMessage).get();
        log.info("sendNotificationToDevice response: {}", response);
    }

    public void sendMulticastNotification(DevicesNotificationRequest request) throws FirebaseMessagingException {
        MulticastMessage multicastMessage = MulticastMessage.builder()
                .addAllTokens(request.getDeviceTokenList().isEmpty() ? getAllDeviceTokens() : request.getDeviceTokenList())
                .setNotification(
                        Notification.builder()
                                .setTitle(request.getTitle())
                                .setBody(request.getBody())
                                .setImage(request.getImageUrl())
                                .build()
                )
                .putAllData(request.getData())
                .build();

        BatchResponse response = FirebaseMessaging.getInstance(firebaseApp).sendEachForMulticast(multicastMessage);
        // Process the response
        for (SendResponse sendResponse : response.getResponses()) {
            if (sendResponse.isSuccessful()) {
                log.info("Message sent successfully to: {}", sendResponse.getMessageId());
            } else {
                log.info("Failed to send message to: {}", sendResponse.getMessageId());
                log.error("Error details: {}", sendResponse.getException().getMessage());
            }
        }
    }

    private List<String> getAllDeviceTokens() {
        // get device tokes from User entity
        // Return a list of device tokens
        return new ArrayList<>();
    }

}

