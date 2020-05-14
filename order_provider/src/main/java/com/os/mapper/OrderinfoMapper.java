package com.os.mapper;

import com.os.entity.Orderinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderinfoMapper {
    Orderinfo selectTablesByTableId(@Param("tableid") int tableid);

    List<Orderinfo> selectAll();

    int deleteByPrimaryKey(Integer orderid);


    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Orderinfo record);

}