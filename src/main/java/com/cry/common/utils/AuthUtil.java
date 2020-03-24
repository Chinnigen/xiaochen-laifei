package com.cry.common.utils;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @program: xiaochen-laofei
 * @description: 安全加密工具类
 * @author: Cry
 * @create: 2020-03-24 09:08
 **/
public class AuthUtil {

    public String sha1(String password, String salt) {
        //加密方式
        String algorithmName = "SHA-1";
        //盐值
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        //加密次数
        int hashIterations = 1;
        SimpleHash result = new SimpleHash(algorithmName, password, byteSalt, hashIterations);
        //Md2Hash Md5Hash Sha1Hash Sha256Hash Sha384Hash Sha512Hash 最后都是调用SimpleHash加密
        //Md5Hash r = new Md5Hash(password,byteSalt,hashIterations);
        return result.toHex();
    }
}
