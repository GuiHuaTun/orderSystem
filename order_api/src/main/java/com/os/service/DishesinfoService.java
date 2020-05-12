package com.os.service;


import com.os.entity.Dishesinfo;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 10:11
 */
public interface DishesinfoService {
    List<Dishesinfo> selectAll();

    int deleteByPrimaryKey(Integer dishesid);


    int insertSelective(Dishesinfo record);

    Dishesinfo selectByPrimaryKey(Integer dishesid);

    int updateByPrimaryKeySelective(Dishesinfo record);

    List<Dishesinfo> selectDishesByRec();
}
