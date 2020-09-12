package com.xjh.fe.service;

import com.xjh.fe.mapper.ResumeMapper;
import com.xjh.fe.model.Resume;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XuJinghui on 2019/11/3.
 */
@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Resource
    private ResumeMapper resumeMapper;

    public int insertIntroSend(Resume resume) {
        return resumeMapper.insertIntroSend(resume);
    }

    public List<Resume> getAllSendApply() {
        return resumeMapper.getAllSendApply();
    }

    public Map<String, Object> getIntroById(int id) {
        return resumeMapper.getIntroById(id);
    }

    @Override
    public List<Resume> getResumeByUid(String uid) {
        return resumeMapper.getResumeByUid(uid);
    }

    @Override
    public int deleteById(int id) {
        return resumeMapper.deleteById(id);
    }

    @Override
    public int updateStatusById(int id, int status) {
        return resumeMapper.updateStatusById(id, status);
    }

    @Override
    public int updateResume(Resume resume) {
        return resumeMapper.updateResume(resume);
    }

    @Override
    public List<Map<String, Object>> getResumeByUidAndStatus(String uid, int status) {
        return resumeMapper.getResumeByUidAndStatus(uid, status);
    }

    @Override
    public Resume getResumeById(int id) {
        return resumeMapper.getResumeById(id);
    }

    @Override
    public int updateSendTimeById(int id, Date send_time) {
        return resumeMapper.updateSendTimeById(id, send_time);
    }

    public List<Map<String, Object>> getAllIntro(int status) {
        return resumeMapper.getAllIntro(status);
    }
}
