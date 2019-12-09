package org.tuliu.land.transfer.tuliutransfercloudparent.service.impl;


import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.FeignService;

/**
 * 获取feign回退原因
 * FeignService的FallbackFactory类,该类实现FallbackFactory接口,并覆写create方法
 */

@Component
public class TestFailFallbackFactory implements FallbackFactory<FeignService> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestFailFallbackFactory.class);

    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService() {
            @Override
            public String health() {
                //日志最好放在各个fallback方法中,不要直接放在create方法中
                //否则在引用启动时就会打印该日志
                TestFailFallbackFactory.LOGGER.info("fallback; reason was :", throwable);

                return "from TestFailFallbackFactory";
            }
        };
    }
}
