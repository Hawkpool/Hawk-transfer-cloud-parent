package org.tuliu.land.transfer.tuliutransfercloudparent.service.impl;

import org.springframework.stereotype.Component;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.FeignService;

@Component
public class TestFail implements FeignService {
    //通过继承 feign接口, 使feign与Hystrix整合 ,实现服务降级
    @Override
    public String health() {
        return "boom 服务炸了";
    }
}
