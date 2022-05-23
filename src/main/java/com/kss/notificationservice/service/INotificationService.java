package com.kss.notificationservice.service;

import com.kss.notificationservice.entity.NotificationEntity;

import java.util.List;

public interface INotificationService {
    List<NotificationEntity> getNotification(String userId, int pageNo , int size) ;
    void updateNotificationRead(String userId, String notificationId);
}
