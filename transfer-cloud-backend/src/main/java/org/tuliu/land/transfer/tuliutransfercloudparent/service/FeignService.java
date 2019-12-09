package org.tuliu.land.transfer.tuliutransfercloudparent.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.impl.TestFail;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.impl.TestFailFallbackFactory;

//@FeignClient(value = "microservice-transfer-test", fallback = TestFail.class)
//@FeignClient(value = "microservice-transfer-test", fallbackFactory = TestFailFallbackFactory.class)//带日志记录错误原因版本
public interface FeignService {

    @RequestMapping(value = "/health", method= RequestMethod.GET)
    String health();

}
