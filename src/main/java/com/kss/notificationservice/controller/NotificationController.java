package com.kss.notificationservice.controller;

import com.kss.notificationservice.entity.NotificationEntity;
import com.kss.notificationservice.model.common.ResponseData;
import com.kss.notificationservice.service.INotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Notification")
@RestController
@RequestMapping(value = "/notification")
public class NotificationController {


    @Autowired
    INotificationService iNotificationService;

    @ApiOperation("Get Notification")
    @GetMapping(value = "/e/{user_id}")
    public ResponseData<List<NotificationEntity>> getNotification(@PathVariable("user_id") String userId, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "20") Integer size) {
        return new ResponseData<List<NotificationEntity>>().success(iNotificationService.getNotification(userId, page, size));
    }


    @ApiOperation("update read notification")
    @PostMapping(value = "/e/{user_id}")
    public ResponseData<Void> updateReadNotification(@PathVariable("user_id") String userId, @RequestParam(value = "notification_id") String notificationId) {
        iNotificationService.updateNotificationRead(userId, notificationId);
        return new ResponseData<>();
    }
}
