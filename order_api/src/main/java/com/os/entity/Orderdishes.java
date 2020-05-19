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
public class Orderdishes implements Serializable {
    private Integer odid;

    private Orderinfo orderinfo;

    private Dishesinfo dishesinfo;

    private Integer num;

    private Integer status;
}