package com.xjh.fe.service;

import com.xjh.fe.model.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    List<User> getUserByPhone(String phone);

    List<User> getAllUser();

    List<User> getUserByUnameAndPwd(String uname, String pwd);

    List<User> getUserByUname(String uname);

    User getUserByUid(String uid);

    int updateUser(User user);

    int updatePhoto(String uid, String photo);

    int modifyUserPwd(String uid, String pwd);

    int resetPwd(String phone, String pwd);

    int insertUser(String uid, String nickname, String pwd, String phone, Integer power, Date regist_time);

    int modifyUserStatus(String uid, int status);

    int educationCertification(String uid,String school,String degree,String studentCard);

    int updateIsIdentify(String uid,int isIdentify);

}
