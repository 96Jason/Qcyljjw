package com.xjh.fe.mapper;

import com.xjh.fe.model.Friend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface FriendMapper {
    /**
     * 获取好友列表
     * @param uid
     * @return
     */
//    @Select("select uid,uname,photo from fe_user where uid in (select friendid from fe_friend where myid=#{uid})")
//    List<Friend> getFriendList(String uid);

    /**
     * 获取好友列表
     * @param uid
     * @return
     */
    @Select("select u.uid,u.uname,u.photo from fe_friend f\n" +
            "LEFT JOIN (select sender,receiver,MAX(sendTime) as sendTime from fe_chat where sender=#{uid} GROUP BY receiver) c1 \n" +
            "on f.friendid=c1.receiver\n" +
            "LEFT JOIN (select sender,receiver,MAX(sendTime) as fromTime from fe_chat where receiver=#{uid} GROUP BY sender) c2\n" +
            "on f.friendid=c2.sender\n" +
            "LEFT JOIN (select uid,uname,photo from fe_user) u\n" +
            "on f.friendid = u.uid\n" +
            "where myid=#{uid}\n" +
            "ORDER BY c2.fromTime desc, c1.sendTime desc")
    List<Friend> getFriendList(String uid);

    /**
     * 添加好友
     * @param myid
     * @param friendid
     * @return
     */
    @Insert("insert into fe_friend values(#{myid},#{friendid})")
    int addFriend(@Param("myid") String myid, @Param("friendid") String friendid);

    @Select("select * from fe_friend where (myid, friendid) in ((#{myid},#{friendid}))")
    Map<String, Object> searchFriendById(@Param("myid") String myid, @Param("friendid") String friendid);

    @Select("select * from fe_friend where myid=#{myid} and friendid=#{friendid}")
    Map<String, Object> searchFriendByMyIdAndFriendId(@Param("myid") String myid, @Param("friendid") String friendid);


}
