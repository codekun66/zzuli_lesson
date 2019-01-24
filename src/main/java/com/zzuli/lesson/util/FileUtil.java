package com.zzuli.lesson.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 * @Author xk
 * @Date 190118
 */

public class FileUtil {

	   
    public static void uploadFile(MultipartFile multipartFile) throws Exception {
        // 获取的是用户提交的文件名字，例如1.jpg、C:\\user\\lisi\\1.gif、a.b.c.gif等
        String originalFilename = multipartFile.getOriginalFilename();
        // 获取Input控件中的name属性值
        String name = multipartFile.getName();
        System.out.println("name=" + name);
        System.out.println("originalFilename=" + originalFilename);
        // 开始将用户上传的文件保存到对应的盘符中去
        // 动态生成文件名--->UUID(生成全球唯一的标识符，网卡号+时间戳)
        String randomUUID = UUID.randomUUID().toString();
        // 通过originalFilename来获取文件的后缀名
        int index = originalFilename.lastIndexOf(".");
        String exet = originalFilename.substring(index);
        // 根据当前的系统时间生成对应的文件夹：格式为yyyyMMdd\\HH\\mm\\ss
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String dateStr = sdf.format(date); // D:\\uploads\\20180824 String
        String filePath = "D:\\uploads\\" + dateStr;
        System.out.println("filePath=" + filePath);
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        filePath += "\\" + randomUUID + exet;
        multipartFile.transferTo(new File(filePath));// ctrl+1
    }
}
