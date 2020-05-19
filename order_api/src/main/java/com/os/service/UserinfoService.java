package com.os.service;


import com.os.entity.Userinfo;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 10:14
 */
public interface UserinfoService {

    List<Userinfo> selectAll(String useraccount,int roleid);

    Userinfo loginUser(Userinfo userinfo);

    Userinfo selectAccount(String account);

    int deleteByPrimaryKey(Integer userid);


    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Userinfo record);


    List<Userinfo> selectUserByRoleId(int roleid);

}
