package com.xjh.fe.controller;

import com.xjh.fe.model.Resume;
import com.xjh.fe.model.User;
import com.xjh.fe.service.ResumeService;
import com.xjh.fe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XuJinghui on 2019/11/3.
 */
@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserService userService;

    /**
     * 插入家教信息 第二版
     * @param resume
     * @return
     */
    @RequestMapping("/insertIntroSend")
    @ResponseBody
    public String insertIntroSend(Resume resume){
        User user = userService.getUserByUid(resume.getUser_id());//查询用户信息
        if (user != null){
            if(user.getUname() == null || user.getUname().equals("")){
                return "userInfoNotComplete";//用户信息不完善，告诉用户先完善信息再操作
            }
        }
        if (resume.getStatus() == 1){
            List<Map<String, Object>> resumeList = resumeService.getResumeByUidAndStatus(resume.getUser_id(), resume.getStatus());//查询用户已发布简历信息
            if (!resumeList.isEmpty()){
                return "existResumeIssue";//存在已发布的简历信息，不能再发布
            }
        }

        resume.setSend_time(new Date());
        int result = resumeService.insertIntroSend(resume);
        if (result > 0 ){
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 获取所有的家教信息
     * @return
     */
    @RequestMapping("/getAllSendApply")
    @ResponseBody
    public List<Resume> getAllSendApply(){
        return resumeService.getAllSendApply();
    }

    /**
     * 获取所有的家庭老师列表（包括一些个人信息，联表）
     * @return
     */
    @RequestMapping("/getAllIntro")
    @ResponseBody
    public List<Map<String, Object>> getAllIntro(int status){
        return resumeService.getAllIntro(status);
    }

    /**
     * 根据id获取Intro信息(包括一些个人信息，联表)
     * @param id
     * @return
     */
    @RequestMapping("/getIntroById")
    @ResponseBody
    public Map<String, Object> getIntroById(int id){
        return resumeService.getIntroById(id);
    }

    /**
     * 根据uid获取个人简历信息
     * @param uid
     * @return
     */
    @RequestMapping("/getResumeByUid")
    @ResponseBody
    public List<Resume> getResumeByUid(String uid){
        return resumeService.getResumeByUid(uid);
    }

    /**
     * 根据简历id删除简历
     * @param id
     * @return
     */
    @RequestMapping("/deleteResumeById")
    @ResponseBody
    public String deleteResumeById(int id){
        int result = resumeService.deleteById(id);
        if(result > 0){
            return "success";
        }
        return "error";
    }

    /**
     * 根据简历id更新简历发布状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateResumeStatusById")
    @ResponseBody
    public String updateResumeStatusById(int id, int status){
        int result = resumeService.updateStatusById(id, status);
        if(result > 0){
            return "success";
        }
        return "error";
    }

    /**
     * 根据id更新简历的发布时间
     * @param id
     * @return
     */
    @RequestMapping("/updateResumeSendTimeById")
    @ResponseBody
    public Map<String ,Object> updateResumeSendTimeById(int id){
        Map<String, Object> map = new HashMap<>();
        int result = resumeService.updateSendTimeById(id, new Date());
        Resume resume = resumeService.getResumeById(id);
        if(resume == null){
            map.put("resume","{}");
        }else {
            map.put("resume",resume);
        }
        if (result > 0){
            map.put("status",true);
        }else {
            map.put("status",false);
        }
        return map;
    }

    /**
     * 根据简历id获取简历信息
     * @param id
     * @return
     */
    @RequestMapping("/getResumeById")
    @ResponseBody
    public Resume getResumeById(int id){
        return resumeService.getResumeById(id);
    }

    /**
     * 编辑简历
     * @param resume
     * @return
     */
    @RequestMapping("/updateResume")
    @ResponseBody
    public int updateResume(Resume resume){
        return resumeService.updateResume(resume);
    }

}
