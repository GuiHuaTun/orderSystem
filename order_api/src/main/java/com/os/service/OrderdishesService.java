package com.os.service;


import com.os.entity.Orderdishes;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 10:12
 */
public interface OrderdishesService {
    List<Orderdishes> selectAll();

    int deleteByPrimaryKey(Integer odid);


    int insertSelective(Orderdishes record);

    Orderdishes selectByPrimaryKey(Integer odid);

    int updateByPrimaryKeySelective(Orderdishes record);

    List<Orderdishes> selectById(Integer id);

    List<Orderdishes> selectByStatus(Integer status);
}
