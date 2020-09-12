package com.xjh.fe.model;

import java.util.Date;

/**
 * Created by XuJinghui on 2019/11/5.
 */
public class SendRecruit {

    private int id;
    private String user_id;
    private String unit;
    private String subject;
    private String stu_intro;
    private String pattern;
    private String area;
    private String address;
    private double salary;
    private String work_require;
    private Date send_time;
    private Date end_time;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStu_intro() {
        return stu_intro;
    }

    public void setStu_intro(String stu_intro) {
        this.stu_intro = stu_intro;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWork_require() {
        return work_require;
    }

    public void setWork_require(String work_require) {
        this.work_require = work_require;
    }

    public Date getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
