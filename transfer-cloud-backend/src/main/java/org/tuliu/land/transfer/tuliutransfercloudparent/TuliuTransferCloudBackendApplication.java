package org.tuliu.land.transfer.tuliutransfercloudparent;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

//import org.springframework.cloud.config.server.EnableConfigServer;

@Configuration
@SpringBootApplication
//开启分布式事务
@EnableDistributedTransaction
//使用Feign调用Hystrix自动配置
@EnableFeignClients(defaultConfiguration = FeignClientsConfiguration.class)
//启用Hystrix
@EnableCircuitBreaker
//启用注册发现 consul配置
@EnableDiscoveryClient
//@EnableHystrix
//扫描mapper路径
@MapperScan("org.tuliu.land.transfer.tuliutransfercloudparent.mapper")
@EnableScheduling
//@EnableConfigServer
public class TuliuTransferCloudBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuliuTransferCloudBackendApplication.class, args);
	}

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
