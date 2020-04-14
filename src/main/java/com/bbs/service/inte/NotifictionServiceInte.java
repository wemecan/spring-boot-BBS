package com.bbs.service.inte;

import com.bbs.pojo.Notifiction;

import java.util.List;

public interface NotifictionServiceInte {

    /**
     * 获取通知
     * @param userId
     * @return
     */
    List<Notifiction> queryNotifiction(Integer userId);

    /**
     * 把通知改为已读
     * @param notifictionId
     * @return
     */
    Integer readNotifiction(Integer notifictionId);

    /**
     * 获取用户所有未读通知
     * @param userId
     * @return
     */
    Integer getUnreadNotifier(Integer userId);
}
