package cn.bdqn.itrip.utils;

import org.springframework.util.DigestUtils;

/**
 * MD5加密工具类
 */
public class EncryptionUtil {

    public static String md5Encryption(String value){
        return DigestUtils.md5DigestAsHex(value.getBytes());
    }

}
