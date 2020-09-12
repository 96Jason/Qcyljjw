package com.xjh.fe.mapper;

import com.xjh.fe.model.User;
import com.xjh.fe.utils.SimpleUpdateExtendedLanguageDriver;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 根据手机号获取用户信息
     * @param phone
     * @return
     */
    @Select("select * from fe_user where phone=#{phone}")
    List<User> getUserByPhone(String phone);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from fe_user")
    List<User> getAllUser();

    /**
     * 根据用户名、密码查询用户
     * @param uname
     * @param pwd
     * @return
     */
    @Select("select * from fe_user where (uid=#{uname} or phone=#{uname}) and pwd=#{pwd}")
    List<User> getUserByUnameAndPwd(@Param("uname") String uname, @Param("pwd") String pwd);

    /**
     * 根据uname（这里的uname包括用户名、帐号、手机）查询
     * @param uname
     * @return
     */
    @Select("select * from fe_user where uid=#{uname} or phone=#{uname}")
    List<User> getUserByUname(@Param("uname") String uname);

    /**
     * 根据uid查询
     * @param uid
     * @return
     */
    @Select("select * from fe_user where uid=#{uid,jdbcType=VARCHAR}")
    User getUserByUid(@Param("uid") String uid);

    /**
     * 更新用户信息，只更新修改部分
     * @param user
     * @return
     */
    @Update("update fe_user (#{user}) WHERE uid =#{uid}")
    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    int updateUser(User user);

    /**
     * 修改头像
     * @param uid
     * @param photo
     * @return
     */
    @Update("update fe_user set photo=#{photo} where uid=#{uid}")
    int updatePhoto(@Param("uid") String uid, @Param("photo") String photo);

    /**
     * 修改用户密码
     * @param uid
     * @param pwd
     * @return
     */
    @Update("update fe_user set pwd=#{pwd} where uid=#{uid}")
    int modifyUserPwd(@Param("uid") String uid,@Param("pwd") String pwd);

    /**
     * 重置密码 第二版本增加
     * @param phone
     * @param pwd
     * @return
     */
    @Update("update fe_user set pwd=#{pwd} where phone=#{phone}")
    int resetPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * 个性用户状态
     * @param uid
     * @param status
     * @return
     */
    @Update("update fe_user set status=#{status} where uid=#{uid}")
    int modifyUserStatus(@Param("uid")String uid,@Param("status")int status);

    @Update("update fe_user set school=#{school},degree=#{degree},studentCard=#{studentCard},isIdentify=0 where uid=#{uid}")
    int educationCertification(@Param("uid")String uid,@Param("school")String school,@Param("degree")String degree,@Param("studentCard")String studentCard);

    /**
     * 用户注册
     * @param uid
     * @param nickname
     * @param pwd
     * @param phone
     * @param regist_time
     * @return
     */
    @Insert("insert into fe_user(uid,nickname,pwd,power,status,phone,photo,regist_time) values(#{uid},#{nickname},#{pwd},#{power},1,#{phone},'userPhoto/userPhoto.jpg',#{regist_time,jdbcType=TIMESTAMP})")
    int insertUser(@Param("uid") String uid, @Param("nickname") String nickname, @Param("pwd") String pwd, @Param("phone") String phone, @Param("power") Integer power, @Param("regist_time") Date regist_time);

    @Update("update fe_user set isIdentify = #{isIdentify} where uid = #{uid}")
    int updateIsIdentify(@Param("uid")String uid,@Param("isIdentify")int isIdentify);

}
