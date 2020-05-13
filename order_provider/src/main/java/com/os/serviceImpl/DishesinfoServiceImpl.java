package com.os.serviceImpl;

import com.os.entity.Dishesinfo;
import com.os.mapper.DishesinfoMapper;
import com.os.service.DishesinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 11:11
 */
@Service
public class DishesinfoServiceImpl implements DishesinfoService {

    @Autowired
    private DishesinfoMapper dishesinfoMapper;


    @Override
    public List<Dishesinfo> selectAll() {
        return dishesinfoMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer dishesid) {
        return dishesinfoMapper.deleteByPrimaryKey(dishesid);
    }

    @Override
    public int insertSelective(Dishesinfo record) {
        return dishesinfoMapper.insertSelective(record);
    }

    @Override
    public Dishesinfo selectByPrimaryKey(Integer dishesid) {
        return dishesinfoMapper.selectByPrimaryKey(dishesid);
    }

    @Override
    public int updateByPrimaryKeySelective(Dishesinfo record) {
        return dishesinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Dishesinfo> selectDishesByRec() {
        return dishesinfoMapper.selectDishesByRec();
    }
}
