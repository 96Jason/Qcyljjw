package com.xjh.fe.service;

import com.xjh.fe.mapper.UserMapper;
import com.xjh.fe.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    /*注入用户Mapper*/
    @Resource
    private UserMapper userMapper;

    /**
     * 学历认证
     * @param uid
     * @param school
     * @param degree
     * @param studentCard
     * @return
     */
    @Override
    public int educationCertification(String uid, String school, String degree, String studentCard) {
        return userMapper.educationCertification(uid,school,degree,studentCard);
    }

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    public List<User> getUserByPhone(String phone) {
        return userMapper.getUserByPhone(phone);
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int updateIsIdentify(String uid, int isIdentify) {
        return userMapper.updateIsIdentify(uid,isIdentify);
    }

    /**
     * 根据uname、pwd查询
     * @param uname
     * @param pwd
     * @return
     */
    public List<User> getUserByUnameAndPwd(String uname, String pwd){
        return userMapper.getUserByUnameAndPwd(uname, pwd);
    }

    /**
     * 根据uname查询
     * @param uname
     * @return
     */
    public List<User> getUserByUname(String uname){
        return userMapper.getUserByUname(uname);
    }

    /**
     * 根据uid查询
     * @param uid
     * @return
     */
    public User getUserByUid(String uid) {
        return userMapper.getUserByUid(uid);
    }

    /**
     * 更新用户信息方法2
     * @param user
     * @return
     */
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    /**
     * 修改头像
     * @param uid
     * @param photo
     * @return
     */
    public int updatePhoto(String uid, String photo) {
        return userMapper.updatePhoto(uid, photo);
    }

    /**
     * 修改用户密码
     * @param uid
     * @param pwd
     * @return
     */
    public int modifyUserPwd(String uid, String pwd){
        return userMapper.modifyUserPwd(uid, pwd);
    }

    /**
     * 重置密码 第二版本增加
     * @param phone
     * @param pwd
     * @return
     */
    public int resetPwd(String phone, String pwd) {
        return userMapper.resetPwd(phone, pwd);
    }

    /**
     * 用户注册
     * @param uid
     * @param nickname
     * @param pwd
     * @param phone
     * @param regist_time
     * @return
     */
    public int insertUser(String uid, String nickname, String pwd, String phone, Integer power, Date regist_time) {
        return userMapper.insertUser(uid, nickname, pwd, phone, power, regist_time);
    }

    @Override
    public int modifyUserStatus(String uid, int status) {
        return userMapper.modifyUserStatus(uid, status);
    }
}
