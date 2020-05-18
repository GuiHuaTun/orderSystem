package com.os.mapper;


import com.os.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserinfoMapper {
    Userinfo selectAccount(@Param("account") String account);

    List<Userinfo> selectAll(@Param("useraccount")String useraccount, @Param("roleid") int roleid);

    Userinfo loginUser(Userinfo userinfo);

    int deleteByPrimaryKey(Integer userid);


    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Userinfo record);


}