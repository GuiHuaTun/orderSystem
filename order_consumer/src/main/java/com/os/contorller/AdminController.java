package com.os.contorller;

import com.netflix.discovery.converters.Auto;
import com.os.entity.Dishesinfo;
import com.os.entity.Roleinfo;
import com.os.entity.Userinfo;
import com.os.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LMW
 * @create 2020-05-09 14:29
 */

@Controller

public class AdminController {
    private final String url = "http://order-provider/";


    @Autowired
    RestTemplate restTemplate;
    private final int pageSize = 3;

    /*
     * 查询所有的用户
     * */
    @RequestMapping(value = "AllUsers/{pageIndex}/{useraccount}/{roleid}")
    @ResponseBody
    public List<Object> getAll(@PathVariable("pageIndex") Integer pageIndex, @PathVariable("useraccount") String useraccount, @PathVariable("roleid") int roleid) {
        System.out.println("进入getAll");
        System.out.println("--------pageIndex: " + pageIndex);
       /* String index="1";
        String size="2";
        List<Userinfo> ListUser = (List<Userinfo>)restTemplate.getForObject("http://order-provider/userinfoPageHelper",List.class,index,size);
        */
        List<Userinfo> allUser = restTemplate.getForObject(url + "getAllUser/" + useraccount + "/" + roleid, List.class);
        int size = allUser.size();//得到所有的User个数
        System.out.println("size:" + size);
        int totalpage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;//获得总页数
        List<Userinfo> userList = restTemplate.getForObject(url + "userinfoPageHelper/" + pageIndex + "/" + pageSize + "/" + useraccount + "/" + roleid, List.class);
        List<Object> List = new ArrayList<>();
        List.add(totalpage);
        List.add(pageIndex);
        System.out.println("pageIndex:" + pageIndex);
        System.out.println("totalpage:" + totalpage);
        List.add(userList);
        return List;
    }

    ;

    @RequestMapping("getAllRole")
    @ResponseBody
    public List<Object> getAllRole() {
        System.out.println("-------------------------进入getAllRole");
        List<Object> list = new ArrayList<>();
        List<Roleinfo> roleList = restTemplate.getForObject(url + "selectAllRoleinfo", List.class);
        list.add(roleList);
        System.out.println("roleList:" + roleList.size());
        return list;
    }

    @RequestMapping("usersFindById")
    public String usersFindById(int userid, Model model) {
        System.out.println("----------------进入usersFindById");
        System.out.println("userid:" + userid);
        Userinfo userinfo = restTemplate.getForObject(url + "selectUserByID/" + userid, Userinfo.class);

        if (userinfo != null) {
            System.out.println(userinfo);
            model.addAttribute("userinfo", userinfo);
            System.out.println("********************************");
            return "pages/admin/modifyuser";
        }
        return "error";
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(Integer userid) {
        String flag = "false";
        System.out.println("-------------进入deleteUser");
        System.out.println("userid:" + userid);
        int num = restTemplate.getForObject(url + "deleteUser/" + userid, Integer.class);
        if (num > 0) {
            flag = "true";
            return flag;
        }
        return flag;
    }

    /**
     * 图片上传
     *
     * @param uploadFile：上传的图片
     * @param request
     * @return
     */
    @RequestMapping(value = "uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public String[] uploadImg(MultipartFile uploadFile, HttpServletRequest request) throws Exception {
        System.out.println("------------------- uploadImg");
        ByteArrayResource uFile = new ByteArrayResource(uploadFile.getBytes()) {
            @Override
            public long contentLength() {
                return uploadFile.getSize();
            }

            @Override
            public String getFilename() {
                return uploadFile.getOriginalFilename();
            }
        };
        MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<>();
        mvm.add("uploadFile", uFile);
        String path = request.getServletContext().getRealPath("/img/upload");//获取上传文件夹/img/upload的绝对路径
        System.out.println("path: " + path);
        mvm.add("path", path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(mvm, headers);
        ResponseEntity<String> imgPath = restTemplate.postForEntity(url + "adminGetUserImg", requestEntity, String.class);
        System.out.println("imgPath: " + imgPath.getBody());
        String[] str = new String[]{imgPath.getBody()};
        return str;
    }


    //查看在线员工
    @RequestMapping("searchOnlinePeople/{pageIndex}/{roleid}")
    @ResponseBody
    public List searchOnlinePeople(@PathVariable("pageIndex") int pageIndex, @PathVariable("roleid") int roleid) {
        System.out.println(pageIndex + "\t" + roleid);
        List list= restTemplate.getForObject(url + "searchOnlinePeople/" + pageIndex + "/" + pageSize + "/" + roleid, List.class);
        System.out.println(list);
        return list;
    }
}
