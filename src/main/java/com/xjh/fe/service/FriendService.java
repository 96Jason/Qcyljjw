package com.xjh.fe.service;

import com.xjh.fe.model.Friend;

import java.util.List;
import java.util.Map;

public interface FriendService {

    List<Friend> getFriendList(String uid);

    int addFriend(String myid, String friendid);

    Map<String, Object> searchFriendById(String myid, String friendid);

    Map<String, Object> searchFriendByMyIdAndFriendId(String myid, String friendid);

}
