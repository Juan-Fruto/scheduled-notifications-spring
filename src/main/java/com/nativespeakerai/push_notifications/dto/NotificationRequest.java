package com.nativespeakerai.push_notifications.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class NotificationRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String body;
    private String imageUrl;
    private Map<String, String> data = new HashMap<>();
}