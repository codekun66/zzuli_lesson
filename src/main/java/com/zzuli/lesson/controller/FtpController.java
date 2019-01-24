package com.zzuli.lesson.controller;

import com.zzuli.lesson.util.ConstantUtil;
import com.zzuli.lesson.util.DateUtil;
import com.zzuli.lesson.util.FileUtil;
import com.zzuli.lesson.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * FtpUtil工具类 ftp文件上传类
 * @Author xk
 * @Date 190118
 */
@Controller
public class FtpController {

    @Autowired
    private FtpUtil ftpUtil;
    

    @RequestMapping(value = "/uploadFile.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uploadImg(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "上传文件失败");
        //获取用户提交的名称
        String fileName = multipartFile.getOriginalFilename();
        System.out.println(fileName);
        String randomUUID = UUID.randomUUID().toString();
        // 通过originalFilename来获取文件的后缀名
        int index = fileName.lastIndexOf(".");
        String exet = fileName.substring(index);
        String uuidfileName = randomUUID + exet ;
        InputStream inputStream = multipartFile.getInputStream();
        String filePath = ConstantUtil.FTP_PATH.FTP_BASEPATH + DateUtil.FtpDate();
        System.out.println(filePath);
        Boolean flag = ftpUtil.uploadFile(filePath, uuidfileName, inputStream);
        if (flag == true) {
            System.out.println("上传成功");
            map.put("code", "1");
            map.put("msg", "上传文件成功");
        }
        return map; //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
    }
}
