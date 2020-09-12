package com.xjh.fe.service;

import com.xjh.fe.model.SendRecruit;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XuJinghui on 2019/11/5.
 */
public interface RecruitService {

    int insertRecruitSend(SendRecruit sendRecruit);

    List<Map<String,Object>> getAllSendRecruits(int status);

    Map<String,Object> getSendRecruitById(int id);

    List<Map<String,Object>> getRecruitByUidAndStatus(String uid, int status);

    List<SendRecruit> getRecruitByUid(String uid);

    int updateStatusById(int id, int status);

    int deleteById(int id);

    int updateSendTimeById(int id, Date send_time);

    SendRecruit getRecruitById(int id);

    int updateRecruit(SendRecruit sendRecruit);

}
