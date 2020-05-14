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
public class Tables implements Serializable {
    private Integer tableid;

    private String tablename;

    private Integer tablestatus;

    public Tables(Integer tableid, Integer tablestatus) {
        this.tableid = tableid;
        this.tablestatus = tablestatus;
    }
}