package com.chrisliu12138.apiinterface.controller;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * name API
 *
 * @author chrisliu12138
 */
@RestController
@RequestMapping("/name")

public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name) {
        return "GET name is " + name;
    }
//    @GetMapping("/")
//    public String getNameByGet() {
//        return "GET name is ";
//    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST name is " + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        String result = "POST name is " + user.getUsername();
        return result;
    }

//    @PostMapping("/user")
//    public String getUsernameByPost(@RequestBody User user, HttpServerRequest request) {
//
//        String accessKey = request.getHeader("accessKey");
////        String secretKey = request.getHeader("secretKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String sign = request.getHeader("sign");
//        String body = request.getHeader("body");
//        // todo 实际情况应该是去数据库中查是否已分配用户
//
//        if (!accessKey.equals("chris")){
//            throw new RuntimeException("无权限");
//        }
//        if (Long.parseLong(nonce) > 10000){
//            throw new RuntimeException("无权限");
//        }
//        // todo timestamp 时间不能和当前相差5分钟 有点麻烦以后实现
////        if(timestamp){
////
////        }
//
//        // todo 实际情况是从数据库中取出secretKey
//
//        String serverSign = SignUtils.genSign(body, "abcdefgh");
//        if(!sign.equals(serverSign)) {
//            throw new RuntimeException("无权限");
//        }
//        return "POST user name is " + user.getUsername();
//    }

}