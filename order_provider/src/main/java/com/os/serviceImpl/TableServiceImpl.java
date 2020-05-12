package com.os.serviceImpl;

import com.os.entity.Table;
import com.os.mapper.TableMapper;
import com.os.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author R
 * @date 2020/5/7 - 11:13
 */
@Service
public class TableServiceImpl implements TableService {
    @Autowired
    private TableMapper tableMapper;

    @Override
    public Table selectTableByStatus(Integer tablestatus) {
        return tableMapper.selectTableByStatus(tablestatus);
    }

    @Override
    public int deleteByPrimaryKey(Integer tableid) {
        return tableMapper.deleteByPrimaryKey(tableid);
    }

    @Override
    public int insertSelective(Table record) {
        return tableMapper.insertSelective(record);
    }

    @Override
    public Table selectByPrimaryKey(Integer tableid) {
        return tableMapper.selectByPrimaryKey(tableid);
    }

    @Override
    public int updateByPrimaryKeySelective(Table record) {
        return tableMapper.updateByPrimaryKeySelective(record);
    }
}
