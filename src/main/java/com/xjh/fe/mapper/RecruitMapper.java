package com.xjh.fe.mapper;

import com.xjh.fe.model.SendRecruit;
import com.xjh.fe.utils.SimpleUpdateExtendedLanguageDriver;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XuJinghui on 2019/11/5.
 */
@Mapper
public interface RecruitMapper {

    @Insert("insert into fe_recruit values(null,#{user_id},#{unit},#{subject},#{stu_intro},#{pattern},#{area},#{address},#{salary},#{work_require},#{send_time,jdbcType=TIMESTAMP},#{end_time,jdbcType=TIMESTAMP},#{status})")
    int insertRecruitSend(SendRecruit sendRecruit);

    @Select("select u.uname,u.photo,s.* from fe_recruit s,fe_user u where s.user_id=u.uid and s.status=#{status} ORDER BY send_time DESC")
    List<Map<String,Object>> getAllSendRecruits(int status);

    @Select("select u.uname,u.photo,u.phone,u.email,s.* from fe_recruit s,fe_user u where s.user_id=u.uid and s.id=#{id}")
    Map<String,Object> getSendRecruitById(int id);

    @Select("select * from fe_recruit where user_id=#{uid} and status=#{status}")
    List<Map<String,Object>> getRecruitByUidAndStatus(@Param("uid") String uid, @Param("status") int status);

    @Select("select * from fe_recruit where user_id=#{uid}")
    List<SendRecruit> getRecruitByUid(String uid);

    @Update("update fe_recruit set status=#{status} where id=#{id}")
    int updateStatusById(@Param("id") int id, @Param("status") int status);

    @Delete("delete from fe_recruit where id=#{id}")
    int deleteById(int id);

    @Update("update fe_recruit set send_time=#{send_time,jdbcType=TIMESTAMP} where id=#{id}")
    int updateSendTimeById(@Param("id") int id, @Param("send_time") Date send_time);

    @Select("select * from fe_recruit where id=#{id}")
    SendRecruit getRecruitById(int id);

    @Update("update fe_recruit (#{recruit}) where id=#{id}")
    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    int updateRecruit(SendRecruit recruit);

}
