package com.kss.notificationservice.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationItemEntity {
    private String itemId;
    private String title;
    private String body;
    private String url;
    private String type;
}
