package com.zzuli.lesson.controller;

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
    public Map<String, String> uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", "上传文件失败");
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        InputStream inputStream = file.getInputStream();
        String filePath = null;
        Boolean flag = ftpUtil.uploadFile(fileName, inputStream);
        if (flag == true) {
            System.out.println("上传成功");
            filePath = ftpUtil.FTP_BASEPATH + fileName;
            map.put("code", "1");
            map.put("msg", "上传文件成功");
        }
        map.put("path", filePath);
        return map; //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
    }
}
