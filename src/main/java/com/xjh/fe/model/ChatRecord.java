package com.xjh.fe.model;

import java.util.Date;

public class ChatRecord {

    private int id;
    private String sender;
    private String receiver;
    private String msg;
    private Date sendTime;
    private int senderStatus;
    private int receiverStatus;
    private int isRead;

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public int getSenderStatus() {
        return senderStatus;
    }

    public void setSenderStatus(int senderStatus) {
        this.senderStatus = senderStatus;
    }

    public int getReceiverStatus() {
        return receiverStatus;
    }

    public void setReceiverStatus(int receiverStatus) {
        this.receiverStatus = receiverStatus;
    }

    @Override
    public String toString() {
        return "ChatRecord{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", msg='" + msg + '\'' +
                ", sendTime=" + sendTime +
                ", senderStatus=" + senderStatus +
                ", receiverStatus=" + receiverStatus +
                ", isRead=" + isRead +
                '}';
    }
}
