package com.kss.notificationservice.service.impl;

import com.kss.notificationservice.entity.NotificationEntity;
import com.kss.notificationservice.repository.NotificationRepository;
import com.kss.notificationservice.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public List<NotificationEntity> getNotification(String userId, int pageNo , int size) {
        return  notificationRepository.getNotificationEntityByUserIdOrderByCreateTimeDesc(userId, PageRequest.of(pageNo, size, Sort.by("createTime").descending()));
    }

    @Override
    public void updateNotificationRead(String userId, String notificationId) {
        NotificationEntity entity = notificationRepository.findNotificationEntityByIdAndUserId(notificationId, userId);
        if(!entity.isRead()){
            entity.setRead(true);
            notificationRepository.save(entity);
        }
    }
}
