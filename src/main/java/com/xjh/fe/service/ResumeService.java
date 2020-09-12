package com.xjh.fe.service;

import com.xjh.fe.model.Resume;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XuJinghui on 2019/11/3.
 */
public interface ResumeService {

    int insertIntroSend(Resume resume);

    List<Resume> getAllSendApply();

    List<Map<String, Object>> getAllIntro(int status);

    Map<String, Object> getIntroById(int id);

    List<Resume> getResumeByUid(String uid);

    int deleteById(int id);

    int updateStatusById(int id, int status);

    int updateSendTimeById(int id, Date send_time);

    Resume getResumeById(int id);

    List<Map<String, Object>> getResumeByUidAndStatus(String uid, int status);

    int updateResume(Resume resume);

}
