package com.os.controller;

import com.github.pagehelper.PageHelper;
import com.os.entity.Tables;
import com.os.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("setTableId/{tableid}")
    public Tables setTableId(@PathVariable("tableid") int tableid){
        return tableService.selectByPrimaryKey(tableid);
    }
}
