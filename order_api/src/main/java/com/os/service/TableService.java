package com.os.service;


import com.os.entity.Tables;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 10:13
 */
public interface TableService {
    List<Tables> selectTableByStatus(Integer tablestatus);

    int deleteByPrimaryKey(Integer tableid);


    int insertSelective(Tables record);

    Tables selectByPrimaryKey(Integer tableid);

    int updateByPrimaryKeySelective(Tables record);
}
