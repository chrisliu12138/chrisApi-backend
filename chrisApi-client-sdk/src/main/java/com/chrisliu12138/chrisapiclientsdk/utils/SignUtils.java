package com.chrisliu12138.chrisapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具
 */

public class SignUtils {
    /**
     * generate sign 生成签名
     * @param body
     * @param secretKey
     * @return
     */
    public static String genSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA1);
        String content = body + "." + secretKey;
        return md5.digestHex(content);
    }
}
