package com.fengfan.user.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Log4j2
@Component("checkMD5")
public class CheckMD5 {
    private static final String salt = "Salt";

    public String getMd5Pass(String password) {
        return encryption(password);
    }

    private String encryption(String password) {
        String md5Str = DigestUtils.md5DigestAsHex(password.getBytes());
        StringBuffer buffer = new StringBuffer(md5Str);
        buffer.append(salt);
        String md5 = DigestUtils.md5DigestAsHex(buffer.toString().getBytes());
        log.info("md5加密后:{}", md5);
        return md5;
    }

    /**
     * 校验密码
     * @param password 用户输入密码
     * @param md5Str 数据库储存密码
     * @return true or false
     */
    public boolean checkPassword(String password, String md5Str) {
        String encPass = encryption(password);
        return encPass.equals(md5Str);
    }
}
