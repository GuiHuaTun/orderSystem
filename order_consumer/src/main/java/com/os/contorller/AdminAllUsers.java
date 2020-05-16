package com.os.contorller;

import com.netflix.discovery.converters.Auto;
import com.os.entity.Dishesinfo;
import com.os.entity.Roleinfo;
import com.os.entity.Userinfo;
import com.os.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.management.relation.Role;
import java.util.ArrayList;
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
    private final int pageSize=3;
    /*
    * 查询所有的用户
    * */
    @RequestMapping(value="AllUsers/{pageIndex}/{useraccount}/{roleid}")
    @ResponseBody
    public List<Object> getAll(@PathVariable ("pageIndex") Integer pageIndex,@PathVariable ("useraccount") String useraccount,@PathVariable("roleid") int roleid){
        System.out.println("进入getAll");
        System.out.println("--------pageIndex: "+pageIndex);
       /* String index="1";
        String size="2";
        List<Userinfo> ListUser = (List<Userinfo>)restTemplate.getForObject("http://order-provider/userinfoPageHelper",List.class,index,size);
        */
        List<Userinfo> allUser= restTemplate.getForObject("http://order-provider/getAllUser/"+useraccount+"/"+roleid,List.class);
        int size = allUser.size();//得到所有的User个数
        System.out.println("size:"+size);
        int totalpage = size%pageSize==0?size/pageSize:size/pageSize+1;//获得总页数
        List<Userinfo> userList=restTemplate.getForObject("http://order-provider/userinfoPageHelper/"+pageIndex+"/"+pageSize+"/"+useraccount+"/"+roleid, List.class);
        List<Object> List = new ArrayList<>();
        List.add(totalpage);
        List.add(pageIndex);
        System.out.println("pageIndex:"+pageIndex);
        System.out.println("totalpage:"+totalpage);
        List.add(userList);
        return List;
    };

    @RequestMapping("getAllRole")
    @ResponseBody
    public List<Object> getAllRole(){
        System.out.println("-------------------------进入getAllRole");
        List<Object> list  = new ArrayList<>();
        List<Roleinfo> roleList=restTemplate.getForObject("http://order-provider/selectAllRoleinfo",List.class);
        list.add(roleList);
        System.out.println("roleList:"+roleList.size());
        return list;
    }
    @RequestMapping("usersFindById")
    public String usersFindById(int userid, Model model){
        System.out.println("----------------进入usersFindById");
        System.out.println("userid:"+userid);
        Userinfo userinfo = restTemplate.getForObject("http://order-provider/selectUserByID/"+userid,Userinfo.class);

        if(userinfo!=null){
            System.out.println(userinfo);
            model.addAttribute("userinfo",userinfo);
            System.out.println("********************************");
            return "pages/admin/modifyuser";
        }
        return "error";
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(Integer userid){
        String flag="false";
        System.out.println("-------------进入deleteUser");
        System.out.println("userid:"+userid);
        int num = restTemplate.getForObject("http://order-provider/deleteUser/"+userid,Integer.class);
        if(num>0){
            flag="true";
            return flag;
        }
        return flag;
    }
}
