package com.kss.notificationservice.repository;

import com.kss.notificationservice.entity.NotificationEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {
    @Query(value = "{userId:?0}", sort = "{createTime:-1}")
    List<NotificationEntity> getNotificationEntityByUserIdOrderByCreateTimeDesc(String userId, Pageable pageable);

    NotificationEntity findNotificationEntityByIdAndUserId(String id,String userId);
}
