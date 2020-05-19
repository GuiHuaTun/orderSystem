package com.os.mapper;


import com.os.entity.Orderdishes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderdishesMapper {
    List<Orderdishes> selectAll();

    int deleteByPrimaryKey(Integer odid);


    int insertSelective(Orderdishes record);

    Orderdishes selectByPrimaryKey(Integer odid);

    int updateByPrimaryKeySelective(Orderdishes record);

    List<Orderdishes> selectById(Integer id);

    List<Orderdishes> selectByStatus(Integer status);
}