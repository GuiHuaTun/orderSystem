package com.os.serviceImpl;

import com.os.entity.Userinfo;
import com.os.mapper.UserinfoMapper;
import com.os.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 11:14
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public List<Userinfo> selectAll(String useraccount,int roleid) {
        return userinfoMapper.selectAll(useraccount,roleid);
    }

    @Override
    public Userinfo loginUser(Userinfo userinfo) {
        return userinfoMapper.loginUser(userinfo);
    }

    @Override
    public Userinfo selectAccount(String account) {
        return userinfoMapper.selectAccount(account);
    }

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return userinfoMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insertSelective(Userinfo record) {
        return userinfoMapper.insertSelective(record);
    }

    @Override
    public Userinfo selectByPrimaryKey(Integer userid) {
        return userinfoMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        return userinfoMapper.updateByPrimaryKeySelective(record);
    }

}
