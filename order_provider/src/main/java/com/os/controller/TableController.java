package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Tables;
import com.os.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author R
 * @date 2020/5/12 - 17:29
 */
@RestController
public class TableController {

    @Autowired
    TableService tableService;


    @RequestMapping("allocationTable")
    public List<Tables> allocationTable(){
        PageHelper.startPage(1,1);
        List<Tables> tables =tableService.selectTableByStatus(0);
       return tables;
    }

    /**
     * 查询餐桌
     * @param tableid
     * @return
     */
    @RequestMapping("setTableId/{tableid}")
    public Tables setTableId(@PathVariable("tableid") int tableid){
        return tableService.selectTablesByStatusAndId(tableid);
    }

    @RequestMapping("updateTableStatus")
    public int updateTableStatus(@RequestBody Tables tables){
        return tableService.updateByPrimaryKeySelective(tables);
    }
}
