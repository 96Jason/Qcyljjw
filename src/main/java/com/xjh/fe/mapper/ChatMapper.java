package com.xjh.fe.mapper;

import com.xjh.fe.model.ChatRecord;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface ChatMapper {

    /**
     * 查询聊天记录
     * @param sender
     * @param receiver
     * @return
     */
    @Select("select * from fe_chat where sender in (#{sender},#{receiver}) and receiver in (#{sender},#{receiver})")
    List<ChatRecord> getChatRecord(@Param("sender") String sender, @Param("receiver") String receiver);

    /**
     * 获取系统通知
     * @param sender
     * @param receiver
     * @return
     */
    @Select("select * from fe_chat where sender in (#{sender},#{receiver}) and receiver in (#{sender},#{receiver},'all')")
    List<ChatRecord> getSystemInform(@Param("sender") String sender, @Param("receiver") String receiver);

    /**
     * 保存聊天记录
     * @param sender
     * @param receiver
     * @param msg
     * @param sendTime
     * @param senderStatus
     * @param receiverStatus
     * @return
     */
    @Insert("insert into fe_chat values(null,#{sender},#{receiver},#{msg},#{sendTime,jdbcType=TIMESTAMP},#{senderStatus},#{receiverStatus},0)")
    int storeChatRecord(@Param("sender") String sender, @Param("receiver") String receiver, @Param("msg") String msg, @Param("sendTime")Date sendTime, @Param("senderStatus") int senderStatus, @Param("receiverStatus") int receiverStatus);

    @Select("select sender,COUNT(sender) num from fe_chat where receiver = #{receiver} and isRead = 0 GROUP BY sender")
    List<Map<String,Object>> getUnReadNum(String receiver);

    @Update("update fe_chat set isRead = 1 where sender = #{sender} and receiver = #{receiver} and isRead = 0")
    int updateIsRead(@Param("sender")String sender, @Param("receiver") String receiver);

}
