package com.nativespeakerai.push_notifications.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class DevicesNotificationRequest extends NotificationRequest {
    List<String> deviceTokenList = new ArrayList<>();
}