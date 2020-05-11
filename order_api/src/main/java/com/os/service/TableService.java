package com.os.service;


import com.os.entity.Table;

/**
 * @author R
 * @date 2020/5/7 - 10:13
 */
public interface TableService {
    Table selectTableByStatus(Integer tablestatus);

    int deleteByPrimaryKey(Integer tableid);


    int insertSelective(Table record);

    Table selectByPrimaryKey(Integer tableid);

    int updateByPrimaryKeySelective(Table record);
}
