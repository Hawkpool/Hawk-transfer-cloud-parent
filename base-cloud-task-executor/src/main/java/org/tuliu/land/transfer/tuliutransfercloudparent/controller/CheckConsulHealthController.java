package org.tuliu.land.transfer.tuliutransfercloudparent.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * consul 心跳存活检测类
 *
 * @author sandy
 * @version v1.0.0
 * @date 2017/7/6
 */
@RestController
@RequestMapping
public class CheckConsulHealthController {

    @Value("${author}")
    private String author;
    /**
     * 心跳检测
     *
     * @return 能证明存活的任意字符串
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String ping() {
        return "ping ping";
    }

    /**
     * @return
     * @Description: 同ping请求原理一样，请求http://172.16.4.102:8080/health
     */
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String  checkHealth() {
        return "Health ~~";
    }

    @GetMapping("/demo")
    public String demo() {
        return author;
    }

}
