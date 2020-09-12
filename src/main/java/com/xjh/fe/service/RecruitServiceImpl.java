package com.xjh.fe.service;

import com.xjh.fe.mapper.RecruitMapper;
import com.xjh.fe.model.SendRecruit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XuJinghui on 2019/11/5.
 */
@Service
@Transactional
public class RecruitServiceImpl implements RecruitService {

    @Resource
    private RecruitMapper recruitMapper;

    @Override
    public Map<String, Object> getSendRecruitById(int id) {
        return recruitMapper.getSendRecruitById(id);
    }

    @Override
    public List<Map<String, Object>> getRecruitByUidAndStatus(String uid, int status) {
        return recruitMapper.getRecruitByUidAndStatus(uid, status);
    }

    @Override
    public int insertRecruitSend(SendRecruit sendRecruit) {
        return recruitMapper.insertRecruitSend(sendRecruit);
    }

    @Override
    public int updateSendTimeById(int id, Date send_time) {
        return recruitMapper.updateSendTimeById(id, send_time);
    }

    @Override
    public int updateRecruit(SendRecruit sendRecruit) {
        return recruitMapper.updateRecruit(sendRecruit);
    }

    @Override
    public SendRecruit getRecruitById(int id) {
        return recruitMapper.getRecruitById(id);
    }

    @Override
    public int deleteById(int id) {
        return recruitMapper.deleteById(id);
    }

    @Override
    public int updateStatusById(int id, int status) {
        return recruitMapper.updateStatusById(id, status);
    }

    @Override
    public List<SendRecruit> getRecruitByUid(String uid) {
        return recruitMapper.getRecruitByUid(uid);
    }

    public List<Map<String, Object>> getAllSendRecruits(int status) {
        return recruitMapper.getAllSendRecruits(status);
    }
}
