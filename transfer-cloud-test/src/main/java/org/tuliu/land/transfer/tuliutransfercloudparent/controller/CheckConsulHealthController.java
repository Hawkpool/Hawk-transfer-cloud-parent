package org.tuliu.land.transfer.tuliutransfercloudparent.controller;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;
import org.tuliu.land.transfer.tuliutransfercloudparent.domain.testLcn.TestLcn2;
import org.tuliu.land.transfer.tuliutransfercloudparent.mapper.TestLcn2Mapper;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.BussinessA;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.BussinessB;

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

    @Autowired
    BussinessA bussinessA;
    @Autowired
    BussinessB bussinessB;

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
    public String checkHealth() {
        return "Health ~~";
    }

    @GetMapping("/testLcn")
    public String testLcn(String a2,String b2,String c2) throws Exception {
        TestLcn2 testLcn2 = new TestLcn2();
        testLcn2.setA2(a2);
        testLcn2.setB2(b2);
        testLcn2.setC2(c2);
        bussinessA.testA(testLcn2);
        return "SUCCESS";
    }

    @GetMapping("/demo")
    public String demo() {
        //testSeata.test();
        //bussinessA.testA();
        bussinessB.testB();
        return author;
    }

}
