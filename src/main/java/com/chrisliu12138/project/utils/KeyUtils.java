package com.chrisliu12138.project.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import lombok.Data;

/**
 * 生成ak、sk工具
 */
public class KeyUtils {

    @Data
    public static class Key {
        String accessKey;
        String secretKey;

    }

    public static final String ACCESS_KEY_FAULT = "chris";
    public static final String SECRET_KEY_FAULT = "chris";

    public static Key genKey(String userAccount) {
        Key key = new Key();
        String accessKey = DigestUtil.md5Hex(ACCESS_KEY_FAULT + userAccount + RandomUtil.randomNumbers(5));
        String secretKey = DigestUtil.md5Hex(SECRET_KEY_FAULT + userAccount + RandomUtil.randomNumbers(5));
        key.setAccessKey(accessKey);
        key.setSecretKey(secretKey);
        return key;
    }
}
