package org.tuliu.land.transfer.tuliutransfercloudparent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.TestLcnFeignService;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.TestLcnLocalService;

@RestController
public class TestLcnController {

    @Autowired
    TestLcnLocalService testLcnLocalService;

    @GetMapping(value = "/testLcn")
    public String testLcn(String a1,String b1,String c1)  {
        //测试testLcn功能 使用feign简化调用 (整合了hystrixs实现快速响应,但需要在响应中手动抛错实现事务回滚)
        try {
            String result = testLcnLocalService.testLcn(a1,b1,c1);
            System.out.println(result);
            return result;
        }catch (Exception e) {
            return  "boom";
        }

    }

}
