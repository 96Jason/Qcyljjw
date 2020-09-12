package com.xjh.fe.controller;

import com.xjh.fe.model.User;
import com.xjh.fe.service.UserService;
import com.xjh.fe.utils.CacheMap;
import com.xjh.fe.utils.SendMessageUtil;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class UserController {
    //注入用户Service
    @Autowired
    private UserService userService;
    /**
     * 用于缓存手机验证码的键值对
     */
    private static CacheMap cacheMap = new CacheMap();

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/userList")
    @ResponseBody
    public List<User> getAllUser(){
        List<User> list = userService.getAllUser();
        return list;
    }

    /**
     * 登录普通版
     * @param uname
     * @param pwd
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public User login(String uname, String pwd, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        List<User> list = userService.getUserByUnameAndPwd(uname, pwd);
        if(list.isEmpty()){
            return new User();
        }else {
            User user = list.get(0);
            session.setAttribute("User",user);//设置会话属性，用于请求拦截
            return user;
        }
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.removeAttribute("User");
        return "redirect:/index.html";
    }

    /**
     * 发送注册短信信息
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendVerificationCode")
    public String sendVerificationCode(String phone){
        List<User> userList = userService.getUserByPhone(phone);
        if(!userList.isEmpty()){
            return "existed";
        }
        String code = "";//验证码
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            code += random.nextInt(10);
        }
        String result = SendMessageUtil.sendMessage(code, phone, 481068);
        if(result == "success"){
            cacheMap.put(phone,code);
            return "success";
        }else {
            return "failure";
        }
    }

    /**
     * 发送修改密码短信
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendCodeForModifyPwd")
    public String sendCodeForModifyPwd(String phone){
        List<User> userList = userService.getUserByPhone(phone);
        if(userList.isEmpty()){
            return "notExisted";
        }else {
            String code = "";//验证码
            Random random = new Random();
            for(int i = 0; i < 6; i++){
                code += random.nextInt(10);
            }
            String result = SendMessageUtil.sendMessage(code, phone, 527681);
            if(result == "success"){
                cacheMap.put(phone,code);
                return "success";
            }else {
                return "failure";
            }
        }
    }

    /**
     * 用户注册
     * @param uid
     * @param pwd
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(String uid, String pwd, String phone, String code, Integer power){
        String _code = cacheMap.get(phone);
        String nickname = uid;//注册时默认昵称与uid相同
        if(_code.equals(code)){
            cacheMap.remove(phone);//去掉验证码
            int result = userService.insertUser(uid, nickname, pwd, phone, power, new Date());
            if(result>0){
                return "success";
            }else {
                return "registerError";//注册异常失败（服务器异常）
            }
        }
        return "codeError";//验证码不正确
    }

    /**
     * 登录检查（检查用户名是否存在，密码是否正确）
     * @param uname
     * @param pwd
     * @return
     */
    @RequestMapping("loginCheck")
    @ResponseBody
    public String loginCheck(String uname, String pwd){
        List<User> nameList = userService.getUserByUname(uname);
        if(nameList.isEmpty()){
            return "noUser";
        }else {
            List<User> userList = userService.getUserByUnameAndPwd(uname, pwd);
            if(userList.isEmpty()){
                return "pwdError";
            }else {
                User user = userList.get(0);
                if(user.getStatus()==0){
                    return "disabled";
                }else {
                    return "success";
                }
            }
        }
    }

    /**
     * 登录前用户名检查
     * @param uname
     * @return
     */
    @RequestMapping("/unameCheck")
    @ResponseBody
    public String unameCheck(String uname){
        List<User> nameList = userService.getUserByUname(uname);
        if(nameList.isEmpty()){
            return "noUser";
        }else {
            return "exist";
        }
    }

    /**
     * 获取个人信息
     * @param uid
     * @return
     */
    @RequestMapping("/personalInfo")
    @ResponseBody
    public User personalInfo(String uid){
        User user = userService.getUserByUid(uid);
        return user;
    }

    /**
     * uid检验（注册时用）
     * @param uid
     * @return
     */
    @RequestMapping("/uidCheck")
    @ResponseBody
    public String uidCheck(String uid){
        User user = userService.getUserByUid(uid);
        if (user == null){
            return "noExist";
        }
        return "exist";
    }

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    @RequestMapping("/getUserByPhone")
    @ResponseBody
    public String getUserByPhone(String phone){
        List<User> nameList = userService.getUserByPhone(phone);
        if(nameList.isEmpty()){
            return "noExist";
        }else {
            return "exist";
        }
    }

    /*获取文件存储真实路径*/
    @Value("${web.upload-path}")
    String fileStorePath;

    @RequestMapping("/uploadPhoto")
    @ResponseBody
    public String uploadPhoto(String uid, MultipartFile photo) throws IOException {
        if(photo.isEmpty()==false){
            String original_name = photo.getOriginalFilename();//文件原始名
            String ext = original_name.substring(original_name.lastIndexOf(".")+1);//文件扩展名
            String photoName = "userPhoto/" + uid + "." + ext;
            User user = userService.getUserByUid(uid);
            String originalPhotoName = user.getPhoto();//原图片名
            if(!originalPhotoName.equals("userPhoto/userPhoto.jpg")){
                File file = new File(fileStorePath + "/" + originalPhotoName);//获取原图片对象
                file.delete();//删除原图片
            }
            photo.transferTo(new File(fileStorePath + "/" + photoName));//以用户uid为名存储上传的文件
            int result = userService.updatePhoto(uid, photoName);
            if(result > 0){
                return "success";
            }
        }
        return "error";
    }

    /**
     * 修改个人信息
     * @param req
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(User req) {
        User user = userService.getUserByUid(req.getUid());
        user.setUname(req.getUname());
        user.setNickname(req.getNickname());
        user.setAge(req.getAge());
        user.setSex(req.getSex());
        user.setEmail(req.getEmail());
        user.setDegree(req.getDegree());
        user.setProfession(req.getProfession());
        user.setSchool(req.getSchool());
        int result = userService.updateUser(user);
        if(result>0){
            return "success";
        }else {
            return "failure";
        }
    }

    /**
     * 原密码校验
     * @param uid
     * @param oldpwd
     * @return
     */
    @RequestMapping("/checkOldPwd")
    @ResponseBody
    public String checkOldPwd(String uid, String oldpwd){
        User user = userService.getUserByUid(uid);
        if(oldpwd.equals(user.getPwd())){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 修改密码
     * @param uid
     * @param pwd
     * @return
     */
    @RequestMapping("/modifyUserPwd")
    @ResponseBody
    public String modifyUserPwd(String uid, String pwd){
        int result = userService.modifyUserPwd(uid,pwd);
        if(result>0){
            return "success";
        }else {
            return "failure";
        }
    }

    /**
     * 通过验证码方式重置密码
     * @param phone
     * @param pwd
     * @param code
     * @return
     */
    @RequestMapping("/resetPwd")
    @ResponseBody
    public String resetPwd(String phone, String pwd, String code){
        String _code = cacheMap.get(phone);
        if(_code.equals(code)){
            cacheMap.remove(phone);
            int result = userService.resetPwd(phone, pwd);
            if(result > 0){
                return "success";
            }else {
                return "resetError";
            }
        }else {
            return "codeError";
        }
    }

    /**
     * 封禁用户
     * @param uid
     * @return
     */
    @RequestMapping("/prohibition")
    @ResponseBody
    public String prohibition(String uid,int status){
        int result = userService.modifyUserStatus(uid, status);
        if(result>0){
            return "success";
        }else {
            return "failure";
        }
    }

    /**
     * 解除封禁
     * @param uid
     * @return
     */
    @RequestMapping("/permission")
    @ResponseBody
    public String permission(String uid, int status){
        int result = userService.modifyUserStatus(uid, status);
        if(result>0){
            return "success";
        }else {
            return "failure";
        }
    }

    /**
     * 修改轮播图片
     * @param location
     * @param file
     * @return
     */
    @RequestMapping("/modifyAdvertisingPhoto")
    @ResponseBody
    public int modifyAdvertisingPhoto(String location, MultipartFile file){
        if(file.isEmpty()==false){
            String original_name = file.getOriginalFilename();//文件原始名
            String ext = original_name.substring(original_name.lastIndexOf(".")+1);//文件扩展名
            String photoName = "carousel/" + location + "." + ext;
            String url = fileStorePath + "/" + photoName;
            try {
                file.transferTo(new File(url));//将图片存储在磁盘上
                /*设置图片尺寸*/
                resizeImage(url,url,1200,350,true);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 1;
    }

    /**
     * 重新生成图片宽、高
     * @param srcPath 图片原路径
     * @param destPath 图片目的路径
     * @param newWith 新的宽度
     * @param newHeight 新的高度
     * @param forceSize 是否强制使用指定宽、高,false:会保持原图片宽高比例约束
     * @return
     * @throws IOException
     */
    private boolean resizeImage (String srcPath, String destPath, int newWith, int newHeight, boolean forceSize) throws IOException {
        if (forceSize) {
            Thumbnails.of(srcPath).forceSize(newWith, newHeight).toFile(destPath);
        } else {
            Thumbnails.of(srcPath).width(newWith).height(newHeight).toFile(destPath);
        }
        return true;
    }

    /**
     * 学历认证
     * @param uid
     * @param school
     * @param degree
     * @param studentCard
     * @return
     * @throws IOException
     */
    @RequestMapping("/educationCertification")
    @ResponseBody
    public String educationCertification(String uid, String school, String degree, MultipartFile studentCard) throws IOException{
        if(studentCard.isEmpty()==false){
            String original_name = studentCard.getOriginalFilename();//文件原始名
            String ext = original_name.substring(original_name.lastIndexOf(".")+1);//文件扩展名
            String photoName = "userPhoto/" + uid+ "edu" + "." + ext;
            User user = userService.getUserByUid(uid);
            String originalPhotoName = user.getStudentCard();//原图片名
            File file2 = new File(fileStorePath + "/" + originalPhotoName);//获取原图片对象
            file2.delete();//删除原图片
            studentCard.transferTo(new File(fileStorePath + "/" + photoName));//以用户uid为名存储上传的文件
            int result = userService.educationCertification(uid, school, degree, photoName);
            if(result > 0){
                return "success";
            }
        }
        return "error";
    }

    @RequestMapping("/updateIsIdentify")
    @ResponseBody
    public String updateIsIdentify(String uid, int isIdentify) {
        if(userService.updateIsIdentify(uid,isIdentify) > 0){
            return "success";
        }
        return "error";
    }

}
