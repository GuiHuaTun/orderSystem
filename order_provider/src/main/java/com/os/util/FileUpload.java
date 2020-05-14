package com.os.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author haohui
 * @create 2020-05-13 9:12
 * 文件上传
 */
public class FileUpload {

    /**
     * 上传文件方法
     * @param uploadFile：要上传的文件
     * @param path：文件的绝对路径
     * @return
     */
    public static String upload(MultipartFile uploadFile, String path){
        String originalname=uploadFile.getOriginalFilename();//获取pic的文件名
        System.out.println("originalname: "+originalname);
        String imgname= UUID.randomUUID().toString();//生成随机数用于组成文件名
        System.out.println("imgname_UUID"+imgname);
        String extraname=originalname.substring(originalname.lastIndexOf("."));//截取pic的后缀名
        System.out.println("extraname: "+extraname);
        String dishesimg=imgname+extraname;//新组成的文件名
        //String path=request.getServletContext().getRealPath("/img/upload");//获取上传文件夹/img/upload的绝对路径
        //System.out.println("path: "+path);
        String imgPath="/img/upload/"+dishesimg;//生成图片在项目中的相对路径
        System.out.println("imgPath: "+imgPath);
        String realPath=path+"/"+dishesimg;
        System.out.println("realPath: "+realPath);
        File file=new File(realPath);//在绝对路径下生成文件
        if(!file.getParentFile().exists()){//判断上传文件夹upload是否存在
            file.getParentFile().mkdirs();//创建上传文件夹upload文件夹
        }
        try {
            uploadFile.transferTo(file);//将pic文件转到file文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return realPath;
    }
}
