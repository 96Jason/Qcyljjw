package com.xjh.fe.mapper;

import com.xjh.fe.model.Resume;
import com.xjh.fe.utils.SimpleUpdateExtendedLanguageDriver;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XuJinghui on 2019/11/3. 第二版 on 2020/1/24
 */
@Mapper
public interface ResumeMapper {

    @Insert("insert into fe_resume values(null,#{user_id},#{salary},#{subject},#{pattern},#{motto},#{address},#{intro},#{send_time,jdbcType=TIMESTAMP},#{end_time,jdbcType=TIMESTAMP},#{status})")
    int insertIntroSend(Resume resume);

    @Select("select * from fe_resume")
    List<Resume> getAllSendApply();

    @Select("select u.uname,u.photo,s.* from fe_resume s,fe_user u where s.user_id=u.uid and s.status=#{status} ORDER BY send_time DESC")
    List<Map<String, Object>> getAllIntro(int status);

    @Select("select u.uname,u.photo,u.profession,\n" +
            "case u.isIdentify WHEN 1 THEN u.school ELSE '' END as school,\n" +
            "case u.isIdentify WHEN 1 THEN u.degree ELSE '' END as education,\n" +
            "u.phone,u.email,u.age,u.sex,s.* \n" +
            "from fe_resume s,fe_user u \n" +
            "where s.user_id=u.uid and s.id= #{id}")
    Map<String, Object> getIntroById(int id);

    @Select("select * from fe_resume where user_id=#{uid}")
    List<Resume> getResumeByUid(String uid);

    @Delete("delete from fe_resume where id=#{id}")
    int deleteById(int id);

    @Update("update fe_resume set status=#{status} where id=#{id}")
    int updateStatusById(@Param("id") int id, @Param("status") int status);

    @Update("update fe_resume set send_time=#{send_time,jdbcType=TIMESTAMP} where id=#{id}")
    int updateSendTimeById(@Param("id") int id, @Param("send_time") Date send_time);

    @Select("select r.*,u.degree as education,u.profession,u.school from fe_resume r LEFT JOIN \n" +
            "(select uid,school,degree,profession from fe_user) u\n" +
            "on r.user_id = u.uid\n" +
            "where r.id = #{id}")
    Resume getResumeById(int id);

    @Select("select * from fe_resume where user_id=#{uid} and status=#{status}")
    List<Map<String, Object>> getResumeByUidAndStatus(@Param("uid") String uid,@Param("status") int status);

    @Update("update fe_resume (#{resume}) where id=#{id}")
    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    int updateResume(Resume resume);

}
