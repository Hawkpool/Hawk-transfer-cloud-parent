package org.tuliu.land.transfer.tuliutransfercloudparent.service.impl;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.FeignService;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.TestLcnFeignService;

@Component
public class TestLcnFeignFallbackFactory implements FallbackFactory<TestLcnFeignService> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestLcnFeignFallbackFactory.class);

    @Override
    public TestLcnFeignService create(Throwable throwable) {
        return new TestLcnFeignService() {

            @Override
            public String testLcn(String a2, String b2, String c2) throws Exception {
                //日志最好放在各个fallback方法中,不要直接放在create方法中
                //否则在引用启动时就会打印该日志
                TestLcnFeignFallbackFactory.LOGGER.info("testLcn成功熔断!!!!  fallback; reason was :", throwable);
                throw new Exception(throwable);
                //return "testLcn成功熔断";
            }
        };
    }
}
