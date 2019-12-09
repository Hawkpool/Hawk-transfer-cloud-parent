此项目为 分布式项目下的 分布式定时任务框架 中的 执行器项目

项目 为springboot项目 , 使用了springcloud依赖, consul注册中心/配置中心, 
feign,hystrix,turbin,zipkin等技术

调用链为  
xxl-job-admin ----> executor执行器(中转站) ----> consul(注册与发现) ----> 各服务接口




