package com.xjh.fe.model;

import java.util.Objects;

public class Friend {

    private String uid;
    private String uname;
    private String photo;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Friend() {
    }

    public Friend(String uid, String uname, String photo) {
        this.uid = uid;
        this.uname = uname;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    /**
     * 重写equal
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        Friend friend = (Friend) o;
        return this.uid.equals(friend.uid) &&
                this.uname.equals(friend.uname) &&
                this.photo.equals(friend.photo);
    }

}
