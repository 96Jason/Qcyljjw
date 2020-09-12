package com.xjh.fe.config;

import com.xjh.fe.utils.LoginHandlerInterceptor;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

}
