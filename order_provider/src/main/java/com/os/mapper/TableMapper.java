package com.os.mapper;

import com.os.entity.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TableMapper {
    Tables selectTablesByStatusAndId(@Param("tableid") int tableid);

    List<Tables> selectTableByStatus(@Param("tablestatus") Integer tablestatus);

    int deleteByPrimaryKey(Integer tableid);


    int insertSelective(Tables record);

    Tables selectByPrimaryKey(Integer tableid);

    int updateByPrimaryKeySelective(Tables record);


}