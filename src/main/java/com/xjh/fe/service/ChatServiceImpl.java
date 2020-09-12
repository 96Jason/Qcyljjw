package com.xjh.fe.service;

import com.xjh.fe.mapper.ChatMapper;
import com.xjh.fe.model.ChatRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    @Resource
    private ChatMapper chatMapper;

    /**
     * 查询聊天记录
     * @param sender
     * @param receiver
     * @return
     */
    public List<ChatRecord> getChatRecord(String sender, String receiver) {
        return chatMapper.getChatRecord(sender, receiver);
    }

    /**
     * 获取系统通知
     * @param sender
     * @param receiver
     * @return
     */
    public List<ChatRecord> getSystemInform(String sender, String receiver) {
        return chatMapper.getSystemInform(sender, receiver);
    }

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
    public int storeChatRecord(String sender, String receiver, String msg, Date sendTime, int senderStatus, int receiverStatus) {
        return chatMapper.storeChatRecord(sender, receiver, msg, sendTime, senderStatus, receiverStatus);
    }

    /**
     * 获取未读聊天记录条数
     * @param receiver
     * @return
     */
    @Override
    public List<Map<String, Object>> getUnReadNum(String receiver) {
        return chatMapper.getUnReadNum(receiver);
    }

    /**
     * 更新聊天记录，将未读改为已读
     * @param sender
     * @param receiver
     * @return
     */
    @Override
    public int updateIsRead(String sender, String receiver) {
        return chatMapper.updateIsRead(sender, receiver);
    }
}
