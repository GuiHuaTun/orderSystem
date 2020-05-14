package com.os.serviceImpl;


import com.os.entity.Orderinfo;
import com.os.mapper.OrderinfoMapper;
import com.os.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 11:12
 */
@Service
public class OrderinfoServiceImpl implements OrderinfoService {

    @Autowired
    private OrderinfoMapper orderinfoMapper;

    @Override
    public Orderinfo selectTablesByTableId(int tableid) {
        return orderinfoMapper.selectTablesByTableId(tableid);
    }

    @Override
    public List<Orderinfo> selectAll() {
        return orderinfoMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer orderid) {
        return orderinfoMapper.deleteByPrimaryKey(orderid);
    }

    @Override
    public int insertSelective(Orderinfo record) {
        return orderinfoMapper.insertSelective(record);
    }

    @Override
    public Orderinfo selectByPrimaryKey(Integer orderid) {
        return orderinfoMapper.selectByPrimaryKey(orderid);
    }

    @Override
    public int updateByPrimaryKeySelective(Orderinfo record) {
        return orderinfoMapper.updateByPrimaryKeySelective(record);
    }
}
