package com.example.luckyfinalproject_meixuanlyanyingl;

public class userInfo {
    private String name;
    private int avatar;

    public userInfo(String name, int avatar){
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}