package com.os.mapper;

import com.os.entity.Dishesinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author R
 * @date 2020/5/6 - 20:21
 */
@Mapper
public interface DishesinfoMapper {
    List<Dishesinfo> selectAll();

    int deleteByPrimaryKey(Integer dishesid);


    int insertSelective(Dishesinfo record);

    Dishesinfo selectByPrimaryKey(Integer dishesid);

    int updateByPrimaryKeySelective(Dishesinfo record);

    List<Dishesinfo> selectDishesByRec();

}
