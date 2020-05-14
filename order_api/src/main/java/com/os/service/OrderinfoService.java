package com.os.service;


import com.os.entity.Orderinfo;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 10:12
 */
public interface OrderinfoService {
    Orderinfo selectTablesByTableId(int tableid);

    List<Orderinfo> selectAll();

    int deleteByPrimaryKey(Integer orderid);


    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Orderinfo record);
}
