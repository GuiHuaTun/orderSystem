package com.os.contorller;

import com.os.entity.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author R
 * @date 2020/5/12 - 17:37
 */
@Controller
public class TableController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 自动分配空桌
     * @return
     */
    @RequestMapping("allocationTable")
    @ResponseBody
    public List<Tables> allocationTable(){
        System.out.println("allocationTable方法");
        List<Tables> tablesList =restTemplate.getForObject("http://order-provider/allocationTable",List.class);
        System.out.println(tablesList);
        return tablesList;
    }

    @RequestMapping("setTableId/{tableid}")
    @ResponseBody
    public Tables setTableId(@PathVariable("tableid") int tableid){
        System.out.println("setTableId方法");
        Tables tables=restTemplate.getForObject("http://order-provider/setTableId/"+tableid,Tables.class);
        return tables;
    }
}
