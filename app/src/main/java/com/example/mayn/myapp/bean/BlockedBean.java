package com.example.mayn.myapp.bean;

import java.io.Serializable;

/**
 * Created by shuqinggang on 2018/6/26.
 */

public class BlockedBean implements Serializable {
    /**
     * username : test@cake.com
     * nickname : test
     * gender : 1
     * country : USA
     * countrycode : CA
     * city :
     * image : https://s3.amazonaws.com/voicecall/868336e6-217a-4458-b6a3-b7c493c87cd0.png
     * type : 1
     * region :
     */

    private String username;
    private String nickname;
    private int gender;
    private String country;
    private String countrycode;
    private String city;
    private String image;
    private int type;
    private String region;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

//    public int getDefaultHead() {
//        if (gender == 1) return R.mipmap.cake_icon_avatar_boy;
//        else return R.mipmap.cake_icon_avatar_girl;
//    }
}
