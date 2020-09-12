package com.xjh.fe.service;

import com.xjh.fe.model.ChatRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ChatService {

    List<ChatRecord> getChatRecord(String sender, String receiver);

    List<ChatRecord> getSystemInform(String sender, String receiver);

    int storeChatRecord(String sender, String receiver, String msg, Date sendTime, int senderStatus, int receiverStatus);

    List<Map<String,Object>> getUnReadNum(String receiver);

    int updateIsRead(String sender, String receiver);

}
