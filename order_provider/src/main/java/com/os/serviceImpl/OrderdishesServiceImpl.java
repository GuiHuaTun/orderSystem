package com.os.serviceImpl;


import com.os.entity.Orderdishes;
import com.os.mapper.OrderdishesMapper;
import com.os.service.OrderdishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author R
 * @date 2020/5/7 - 11:12
 */
@Service
public class OrderdishesServiceImpl implements OrderdishesService {


    @Autowired
    private OrderdishesMapper orderdishesMapper;

    @Override
    public List<Orderdishes> selectAll() {
        return orderdishesMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer odid) {
        return orderdishesMapper.deleteByPrimaryKey(odid);
    }

    @Override
    public int insertSelective(Orderdishes record) {
        return orderdishesMapper.insertSelective(record);
    }

    @Override
    public Orderdishes selectByPrimaryKey(Integer odid) {
        return orderdishesMapper.selectByPrimaryKey(odid);
    }

    @Override
    public int updateByPrimaryKeySelective(Orderdishes record) {
        return orderdishesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Orderdishes> selectById(Integer id) {
        return orderdishesMapper.selectById(id);
    }
}
