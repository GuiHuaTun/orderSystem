package com.os.controller;

import com.os.entity.Roleinfo;
import com.os.service.RoleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author R
 * @date 2020/5/12 - 16:09
 */
@RestController
public class RoleInfoController {
    @Autowired
    RoleinfoService roleinfoService;

    @RequestMapping("selectAllRoleinfo")
    public List<Roleinfo> selectAllRoleinfo(){
        System.out.println("查询所有roleinfo");
        return roleinfoService.selectAll();
    }
}
