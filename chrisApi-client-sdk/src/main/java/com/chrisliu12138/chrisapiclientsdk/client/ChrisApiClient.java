package com.chrisliu12138.chrisapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

import com.alibaba.nacos.shaded.com.google.gson.JsonElement;
//import com.chrisliu12138.chrisapiclientsdk.utils.HttpResponseDataUtils;
//import com.chrisliu12138.chrisapiclientsdk.utils.Params2JsonUtils;
import com.chrisliu12138.chrisapiclientsdk.utils.SignUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import com.chrisliu12138.chrisapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.chrisliu12138.chrisapiclientsdk.utils.SignUtils.genSign;

/**
 * 调用第三方接口的客户端
 *
 * @author chrisliu12138
 */
public class ChrisApiClient {

    private String GATEWAY_HOST = "http://localhost:8123";
    private final String accessKey;

    private final String secretKey;

    public ChrisApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get(GATEWAY_HOST + "/api/name/get/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.post(GATEWAY_HOST + "/api/name/post/", paramMap);
        System.out.println(result);
        return result;
    }

//    public String getUsernameByPost(@RequestBody User user) {
//        //Restful请求
//        String json = JSONUtil.toJsonStr(user);
//        HttpResponse httpResponse = HttpRequest.post("https://localhost:8123/api/name/user/")
//                .body(json)
//                .execute();
//        System.out.println(httpResponse.getStatus());
//        String result = httpResponse.body();
//        System.out.println(result);
//        return result;
//    }


    private Map<String, String> getHeaderMap(String body) {
        Map<String,String> hashMap = new HashMap<>();
        //一定不能用明文在客户端传输密钥
        hashMap.put("accesskey",accessKey);
//        hashMap.put("secretKey",secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body",body); //用户传递的参数
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()/1000));
        hashMap.put("sign",genSign(body, secretKey)); //用户传递的参数
        return hashMap;
    }


    public String getUsernameByPost(User user) {
        //Restful请求
        String json = JSONUtil.toJsonStr(user);

        HttpResponse httpResponse = HttpRequest
                .post(GATEWAY_HOST + "/api/name/user")
//                .charset(StandardCharsets.UTF_8)
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
    /**
     * 随机输出一句冷笑话
     * charset 返回编码类型[gbk|utf-8]默认utf-8
     * encode 返回格式类型[text|js|json]默认text
     *
     * @return 状态码和响应值
     */
//    public ImmutablePair<Integer, String> randomMessage(String params) {
//        String charset, encode;
//        HttpRequest request = HttpRequest.get(GATEWAY_HOST + "/api/randomMessage");
//        if (StringUtils.isNotBlank(params)) {
//            JsonElement jsonParams = Params2JsonUtils.getJsonParams(params);
//            charset = jsonParams.getAsJsonObject().get("charset").getAsString();
//            encode = jsonParams.getAsJsonObject().get("encode").getAsString();
//            // 不传参时使用默认参数
//            request = StringUtils.isNotBlank(charset) ? request.form("charset", charset) : request.form("charset", "utf-8");
//            request = StringUtils.isNotBlank(encode) ? request.form("encode", encode) : request.form("encode", "text");
//        }
//
//        HttpResponse response = request.addHeaders(getHeaderMap(params)).execute();
//        return HttpResponseDataUtils.resData(response);
//    }
}


//    public String testUser(Object requestParams) {
//        String json = JSONUtil.toJsonStr(requestParams);
//
//        HttpResponse response = HttpRequest
//                .post(GATEWAY_HOST + "/api/name/json")
//                .addHeaders(getHeaderMap(json))
//                .body(json)
//                .execute();
//        return response.body();
//    }
//
//    public String getUsernameByPost(User user) {
//        String json = JSONUtil.toJsonStr(user);
//
//        HttpResponse response = HttpRequest
//                .post(GATEWAY_HOST + "/api/invoke/name/json")
//                .addHeaders(getHeaderMap(json))
//                .body(json)
//                .execute();
//        return response.body();
//
//    }