package com.xjh.fe.controller;

import com.xjh.fe.model.ChatRecord;
import com.xjh.fe.service.ChatService;
import com.xjh.fe.service.FriendService;
import com.xjh.fe.service.RecruitService;
import com.xjh.fe.service.ResumeService;
import com.xjh.fe.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private FriendService friendService;
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private ResumeService resumeService;

    /**
     * 获取聊天记录
     * @param sender
     * @param receiver
     * @return
     */
    @RequestMapping("/getChatRecord")
    @ResponseBody
    public List<ChatRecord> getChatRecord(String sender, String receiver){
            if(receiver.equals("0000000000")){//获取系统消息
                return chatService.getSystemInform(sender, receiver);
            }else {//获取普通好友聊天记录
                return chatService.getChatRecord(sender, receiver);
            }
    }

    /**
     * 获取未读聊天条数
     * @param receiver
     * @return
     */
    @RequestMapping("/getUnReadNum")
    @ResponseBody
    public List<Map<String,Object>> getUnReadNum(String receiver){
        return chatService.getUnReadNum(receiver);
    }

    /**
     * 更新聊天记录，将未读改为已读
     * @param sender
     * @param receiver
     * @return
     */
    @RequestMapping("/updateIsRead")
    @ResponseBody
    public int updateIsRead(String sender, String receiver){
        return chatService.updateIsRead(sender, receiver);
    }

//    @RequestMapping("/interested")
//    @ResponseBody
//    public String interested(String sender, String receiver, String articleType){
//        if (sender.equals(receiver)){//如果发送者与接收都是同一个人，返回自恋单词
//            return "narcissism";
//        }
//        Map<String, Object> isFriend = friendService.searchFriendByMyIdAndFriendId(sender, receiver);
//        String url = "";
//        String msg = "";
//        if(articleType.equals("resume")){//如果当前页面是简历页面
//            List<Map<String ,Object>> mapList = recruitService.getRecruitByUidAndStatus(sender, 1);//获取在发布的招聘信息
//            if (mapList.size()>0){//如果存在招聘信息（有招聘信息正在发布才可能对别人的简历感兴趣）
//                url = "47.105.59.61/html/article/fe-recruit.html?id="+mapList.get(0).get("id");//链接地址
//                if(isFriend == null){//未是好友，先添加为好友
//                    friendService.addFriend(sender,receiver);
//                    friendService.addFriend(receiver,sender);
//                }
//                msg="刚刚看了你的简历，很是感兴趣。以下是我的招聘信息链接，如果你也对我的招聘感兴趣，请尽快联系我吧！";
//                chatService.storeChatRecord(sender,receiver,msg,new Date(),1,1);
//                chatService.storeChatRecord(sender,receiver,url,new Date(),1,1);
//                return "success";//操作成功
//            }else {
//                return "noRecruit";//点击感兴趣按钮者还没有发布招聘信息，请先发布
//            }
//        }else if(articleType.equals("recruit")){
//            List<Map<String ,Object>> resumeList = resumeService.getResumeByUidAndStatus(sender, 1);//获取在发布的简历信息
//            if (resumeList.size()>0){//如果存在简历信息（有简历信息正在发布才可能对别人的招聘感兴趣）
//                url = "47.105.59.61/html/article/fe-resume.html?id="+resumeList.get(0).get("id");//链接地址
//                if(isFriend == null){//未是好友，先添加为好友
//                    friendService.addFriend(sender,receiver);
//                    friendService.addFriend(receiver,sender);
//                }
//                msg="希望得到您的青垂，以下是我的简历信息链接，请查收！";
//                chatService.storeChatRecord(sender,receiver,msg,new Date(),1,1);
//                chatService.storeChatRecord(sender,receiver,url,new Date(),1,1);
//                return "success";//操作成功
//            }else {
//                return "noResume";//点击感兴趣按钮者还没有发布招聘信息，请先发布
//            }
//        }
//        return "error";
//    }

    @RequestMapping("/sendRecruitToOthers")
    @ResponseBody
    public String sendRecruitToOthers(String recruit, String sender, String receiver){
        String url = "<a href="+"http://localhost/html/article/fe-recruit.html?id="+recruit+">点我前往</a>",
               msg = "刚刚看了你的简历，很是感兴趣。以下是我的招聘信息链接，如果你也对我的招聘感兴趣，请尽快联系我吧！";
        if(chatService.storeChatRecord(sender,receiver,msg+url,new Date(),1,1) > 0){
            return "success";
        }
        return "failure";
    }

    @RequestMapping("/sendResumeToOthers")
    @ResponseBody
    public String sendResumeToOthers(String resume, String sender, String receiver){
        String url = "<a href="+"http://localhost/html/article/fe-resume.html?id="+resume+">点我前往</a>",
                msg = "希望得到您的青垂，以下是我的简历信息链接!";
        if(chatService.storeChatRecord(sender,receiver,msg+url,new Date(),1,1) > 0){
            return "success";
        }
        return "failure";
    }

    @RequestMapping("/interested")
    @ResponseBody
    public ResponseResult interested(String sender, String receiver, String articleType){
        ResponseResult responseResult = new ResponseResult<List<Map<String,Object>>>();
        responseResult.setCode("200");
        if (sender.equals(receiver)){//如果发送者与接收都是同一个人，返回自恋单词
            responseResult.setMessage("你在自恋的路上已没有对手");
            return responseResult;
        }
        Map<String, Object> isFriend = friendService.searchFriendByMyIdAndFriendId(sender, receiver);
        if(articleType.equals("resume")){//如果当前页面是简历页面
            List<Map<String ,Object>> mapList = recruitService.getRecruitByUidAndStatus(sender, 1);//获取在发布的招聘信息
            if (mapList.size()>0){//如果存在招聘信息（有招聘信息正在发布才可能对别人的简历感兴趣）
                if(isFriend == null){//未是好友，先添加为好友
                    friendService.addFriend(sender,receiver);
                    friendService.addFriend(receiver,sender);
                }
                responseResult.setData(mapList);
                responseResult.setMessage("数据获取成功");
            }else {
                responseResult.setMessage("请先发布招聘信息");
            }
        }else if(articleType.equals("recruit")){
            List<Map<String ,Object>> resumeList = resumeService.getResumeByUidAndStatus(sender, 1);//获取在发布的简历信息
            if (resumeList.size()>0){//如果存在简历信息（有简历信息正在发布才可能对别人的招聘感兴趣）
                if(isFriend == null){//未是好友，先添加为好友
                    friendService.addFriend(sender,receiver);
                    friendService.addFriend(receiver,sender);
                }
                responseResult.setData(resumeList);
            }else {
                responseResult.setMessage("请先发布简历信息");
            }
        }
        return responseResult;
    }

}
