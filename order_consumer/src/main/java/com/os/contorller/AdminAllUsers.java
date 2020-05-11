package com.os.contorller;

import com.netflix.discovery.converters.Auto;
import com.os.entity.Userinfo;
import com.os.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LMW
 * @create 2020-05-09 14:29
 */

@Controller

public class AdminAllUsers {
    @Autowired
    RestTemplate restTemplate;

    /*
    * 查询所有的用户
    * */
    @RequestMapping(value="AllUsers/{pageIndex}/{pageSize}/{useraccount}")
    @ResponseBody
    public List<Userinfo> getAll(@PathVariable ("pageIndex") Integer pageIndex,@PathVariable ("pageSize") Integer pageSize,@PathVariable ("useraccount") String useraccount ){
        System.out.println("进入getAll");
        System.out.println("--------pageIndex: "+pageIndex);
       /* String index="1";
        String size="2";
        List<Userinfo> ListUser = (List<Userinfo>)restTemplate.getForObject("http://order-provider/userinfoPageHelper",List.class,index,size);
        */
        List<Userinfo> userList=restTemplate.getForObject("http://order-provider/userinfoPageHelper/"+pageIndex+"/"+pageSize+"/"+useraccount, List.class);
        return userList;
    };
}
