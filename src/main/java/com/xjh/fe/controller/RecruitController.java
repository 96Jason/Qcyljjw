package com.xjh.fe.controller;

import com.xjh.fe.model.SendRecruit;
import com.xjh.fe.model.User;
import com.xjh.fe.service.RecruitService;
import com.xjh.fe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XuJinghui on 2019/11/5.
 */
@Controller
public class RecruitController {

    @Autowired
    private RecruitService recruitService;
    @Autowired
    private UserService userService;

    @RequestMapping("/insertRecruitSend")
    @ResponseBody
    public String insertRecruitSend(SendRecruit sendRecruit){
        User user = userService.getUserByUid(sendRecruit.getUser_id());//查询用户信息
        if (user != null){
            if(user.getUname() == null || user.getUname().equals("")){
                return "userInfoNotComplete";//用户信息不完善，告诉用户先完善信息再操作
            }
        }
        if (sendRecruit.getStatus() == 1){
            List<Map<String, Object>> resumeList = recruitService.getRecruitByUidAndStatus(sendRecruit.getUser_id(), sendRecruit.getStatus());//查询用户已发布简历信息
            if (!resumeList.isEmpty()){
                return "existRecruitIssue";//存在已发布的简历信息，不能再发布
            }
        }

        sendRecruit.setSend_time(new Date());
        int result = recruitService.insertRecruitSend(sendRecruit);
        if (result > 0 ){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/getAllSendRecruits")
    @ResponseBody
    public List<Map<String,Object>> getAllSendRecruits(int status){
        return recruitService.getAllSendRecruits(status);
    }

    @RequestMapping("/getSendRecruitById")
    @ResponseBody
    public Map<String,Object> getSendRecruitById(int id){
        return recruitService.getSendRecruitById(id);
    }

    @RequestMapping("/getRecruitByUid")
    @ResponseBody
    public List<SendRecruit> getRecruitByUid(String uid){
        return recruitService.getRecruitByUid(uid);
    }

    @RequestMapping("/updateRecruitStatusById")
    @ResponseBody
    public String updateRecruitStatusById(int id, int status){
        int result = recruitService.updateStatusById(id, status);
        if(result > 0){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/deleteRecruitById")
    @ResponseBody
    public String deleteRecruitById(int id){
        int result = recruitService.deleteById(id);
        if(result > 0){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/updateRecruitSendTimeById")
    @ResponseBody
    public Map<String ,Object> updateRecruitSendTimeById(int id){
        Map<String, Object> map = new HashMap<>();
        int result = recruitService.updateSendTimeById(id, new Date());
        SendRecruit recruit = recruitService.getRecruitById(id);
        if(recruit == null){
            map.put("recruit","{}");
        }else {
            map.put("recruit",recruit);
        }
        if (result > 0){
            map.put("status",true);
        }else {
            map.put("status",false);
        }
        return map;
    }

    @RequestMapping("/updateRecruit")
    @ResponseBody
    public int updateRecruit(SendRecruit sendRecruit){
        return recruitService.updateRecruit(sendRecruit);
    }

    @RequestMapping("/getRecruitById")
    @ResponseBody
    public SendRecruit getRecruitById(int id){
        return recruitService.getRecruitById(id);
    }

}
