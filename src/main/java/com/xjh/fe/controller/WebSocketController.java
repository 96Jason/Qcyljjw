package com.xjh.fe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjh.fe.model.ChatRecord;
import com.xjh.fe.service.ChatService;
import com.xjh.fe.service.ChatServiceImpl;
import com.xjh.fe.utils.SpringUtil;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{id}/{xm}")
public class WebSocketController {

    //通过@Autowired、@Resource注入是会报错的，所以通过以下方式来获取对象，https://blog.csdn.net/qq_21082615/article/details/91373094
    private ChatService chatService = SpringUtil.getBean(ChatServiceImpl.class);

    /**
     * 所有在线会话
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    /**
     * 连接成功
     */
    @OnOpen
    public void onOpen(@PathParam(value = "id") String id, Session session) {
        onlineSessions.put(id, session);
    }

    /**
     * 客户端发送消息调用
     */
    @OnMessage
    public void onMessage(String msgCarrier) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ChatRecord chatRecord = mapper.readValue(msgCarrier,ChatRecord.class);//将json字符串转换成java对象
        String receiver = chatRecord.getReceiver();
        if(receiver != null){//私聊
            sendToNamedUser(chatRecord, msgCarrier);
        }
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose(@PathParam(value = "id") String id, Session session) {
        onlineSessions.remove(id);
    }

    /**
     * 连接错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 发送消息给指定的用户
     * @param chatRecord
     * @param msgCarrier
     * @throws IOException
     */
    public void sendToNamedUser(ChatRecord chatRecord, String msgCarrier) throws IOException {
        String sender = chatRecord.getSender();
        String receiver = chatRecord.getReceiver();
        //保存聊天记录
        storeChatRecords(chatRecord);
        //将发送过来的聊天信息返回给发送者，表示消息已经发送成功
        onlineSessions.get(sender).getBasicRemote().sendText(msgCarrier);
        if (onlineSessions.get(receiver) != null) {
            //将发送过来的聊天信息发送给接收者，前提是他在线
            onlineSessions.get(receiver).getBasicRemote().sendText(msgCarrier);
        }
    }

    /**
     * 保存聊天记录
     * @param chatRecord
     */
    public void storeChatRecords(ChatRecord chatRecord){
        String sender = chatRecord.getSender();
        String receiver = chatRecord.getReceiver();
        String msg = chatRecord.getMsg();
        Date sendTime = chatRecord.getSendTime();
        //保存聊天消息到数据库
        int result = chatService.storeChatRecord(sender, receiver, msg, sendTime, 1, 1);
        if(result < 0){
            System.out.println("保存聊天记录失败");
        }
    }

}
