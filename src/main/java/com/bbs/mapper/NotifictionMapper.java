package com.bbs.mapper;

import com.bbs.pojo.Notifiction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifictionMapper {
    /**
     * 创建通知
     * @param notifiction
     * @return
     */
    Integer addNotifiction(Notifiction notifiction);

    /**
     * 获取通知
     * @param userId
     * @return
     */
    List<Notifiction> queryNotifiction(@Param("userId")Integer userId);

    /**
     * 把通知改为已读
     * @param notifictionId
     * @return
     */
    Integer readNotifiction(@Param("notifictionId")Integer notifictionId);

    /**
     * 获取用户所有未读通知
     * @param userId
     * @return
     */
    Integer getUnreadNotifier(@Param("userId")Integer userId);
}
