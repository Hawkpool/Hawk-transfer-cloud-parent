package org.tuliu.land.transfer.tuliutransfercloudparent.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.impl.TestLcnFeignFallbackFactory;

@FeignClient(value = "microservice-transfer-test", fallbackFactory = TestLcnFeignFallbackFactory.class)//带日志记录错误原因版本
//@FeignClient(value = "microservice-transfer-test")
public interface TestLcnFeignService {

    @RequestMapping(value = "/testLcn", method= RequestMethod.GET)
    String testLcn(@RequestParam("a2") String a2, @RequestParam("b2")String b2, @RequestParam("c2")String c2) throws Exception;
}
