package com.xjh.fe.config;

import com.xjh.fe.utils.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * Created by XuJinghui on 2019/10/19.
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        return new WebMvcConfigurer(){

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // /**  表示所有路径下的所有请求
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**").excludePathPatterns("/getAllIntro","/test/**","/userPhoto/**","/carousel/**","/html/protocol.html","/html/article/**","/html/fe-register.html","/html/modify-pwd.html","/index.html","/register","/login","/uidCheck","/getIntroById","/getSendRecruitById","/sendVerificationCode","/sendCodeForModifyPwd","/resetPwd","/unameCheck","/loginCheck","/arclist/**","/bootstrap/**","/css/**","/images/**","/js/**");
            }
        };
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        File file=new File("");
        String path=file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf(File.separator));
        //判断当前操作系统
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            //拦截匹配的请求，并将其要请求的资源路径解释为以下路径（项目所在目录+资源路径）
            registry.addResourceHandler("/userPhoto/**","carousel/**").
                    addResourceLocations("file:"+path+"/familyeduFile/images/userPhoto/","file:"+path+"/familyeduFile/images/carousel/");
        }else{//linux和mac系统
            registry.addResourceHandler("/userPhoto/**","carousel/**").
                    addResourceLocations("file:"+path+"/familyeduFile/images/userPhoto/","file:"+path+"/familyeduFile/images/carousel/");
        }

    }
}
