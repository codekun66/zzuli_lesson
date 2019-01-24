package com.zzuli.lesson.util;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FtpUtil工具类 ftp文件上传类
 * @Author xk
 * @Date 190118
 */
@Component
public class FtpUtil {
    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "172.18.255.43";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "Anonymous";
    //密码
    private static final String FTP_PASSWORD = "";
  
    public boolean uploadFile(String filePath , String originFileName, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ////设置编码为GBK
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            //文件类型为二进制文件
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            boolean y = ftp.makeDirectory(filePath);
            System.out.println(y);
            //ftp是利用changeWorkingDirectory()方法来代替CMD中的命令 cd 的
            boolean x =  ftp.changeWorkingDirectory(filePath);
            System.out.println(x);
            ftp.storeFile(originFileName, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }
}
