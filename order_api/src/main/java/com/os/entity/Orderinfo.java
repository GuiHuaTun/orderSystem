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
public class Orderinfo implements Serializable {
    private Integer orderid;

    private String orderbegindate;

    private String orderenddate;

    private Userinfo userinfo;

    private Integer orderstate;

    private Tables tables;

    public Orderinfo(String orderbegindate, String orderenddate, Integer orderstate) {
        this.orderbegindate = orderbegindate;
        this.orderenddate = orderenddate;
        this.orderstate = orderstate;
    }

    public Orderinfo(String orderbegindate, Userinfo userinfo, Integer orderstate, Tables tables) {
        this.orderbegindate = orderbegindate;
        this.userinfo = userinfo;
        this.orderstate = orderstate;
        this.tables = tables;
    }
}