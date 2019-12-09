package org.tuliu.land.transfer.tuliutransfercloudparent.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.tuliu.land.transfer.tuliutransfercloudparent.service.FeignService;

@RestController
public class TestCheckConsulHealthController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private FeignService feignService ;


    @HystrixCommand(fallbackMethod = "testConsulFallback")
    @GetMapping(value = "/testConsul")
    public String testConsul(){
        //通过注册中心拉取 名为"microservice-transfer-test" 的服务端实例
		ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-transfer-test");
		System.out.println("服务地址：" + serviceInstance.getUri());
		System.out.println("服务名称：" + serviceInstance.getServiceId());
        //测试consul注册消费
        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/health", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }

    @GetMapping(value = "/testFeign")
    public String testFeign(){
        //测试feign功能 使用feign简化调用 (整合了hystrixs实现容错)
        String result = feignService.health();
        System.out.println(result);
        return result;
    }

    @GetMapping(value = "/testConsulChangeContext")
    public String testConsulChangeContext(){
       String result = System.getProperty("BuiBui");
        System.out.println(result);
        return result;
    }


    public String testConsulFallback(){
        return "testConsulFallback";
    }
}
