package com.os.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Userinfo implements Serializable {
    private Integer userid;

    private String useraccount;

    private String userpass;

    private Roleinfo roleinfo;

    private Integer locked;

    private String faceimg;

    public Userinfo(String useraccount, String userpass) {
        this.useraccount = useraccount;
        this.userpass = userpass;
    }

    public Userinfo(Integer userid, Integer locked) {
        this.userid = userid;
        this.locked = locked;
    }
}