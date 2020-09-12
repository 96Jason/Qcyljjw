package com.xjh.fe.controller;

import com.xjh.fe.model.Friend;
import com.xjh.fe.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;

    /**
     * 获取好友列表
     * @param uid
     * @return
     */
    @RequestMapping("/getFriendList")
    @ResponseBody
    public List<Friend> getFriendList(String uid){
        List<Friend> friends = friendService.getFriendList(uid);
        return friends;
    }

    /**
     * 添加好友
     * @param myid
     * @param friendid
     * @return
     */
    @RequestMapping("/addFriend")
    @ResponseBody
    public String addFriend(String myid,  String friendid){
        if(friendService.addFriend(myid, friendid)>0 && friendService.addFriend(friendid,myid)>0){
            return "success";
        }
        return "failure";
    }

    @RequestMapping("/searchFriendById")
    @ResponseBody
    public Boolean searchFriendById(String myid, String friendid){
        Map<String, Object> friend = friendService.searchFriendById(myid, friendid);
        if(friend != null && !friend.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

}
