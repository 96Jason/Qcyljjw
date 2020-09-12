package com.xjh.fe.service;

import com.xjh.fe.mapper.FriendMapper;
import com.xjh.fe.model.Friend;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

    @Resource
    private FriendMapper friendMapper;

    /**
     * 获取好友列表
     * @param uid
     * @return
     */
    public List<Friend> getFriendList(String uid) {
        return friendMapper.getFriendList(uid);
    }

    /**
     * 添加好友
     * @param myid
     * @param friendid
     * @return
     */
    @Override
    public int addFriend(String myid, String friendid) {
        return friendMapper.addFriend(myid, friendid);
    }

    @Override
    public Map<String, Object> searchFriendByMyIdAndFriendId(String myid, String friendid) {
        return friendMapper.searchFriendByMyIdAndFriendId(myid, friendid);
    }

    @Override
    public Map<String, Object> searchFriendById(String myid, String friendid) {
        return friendMapper.searchFriendById(myid, friendid);
    }

}
