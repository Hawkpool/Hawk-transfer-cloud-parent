该项目整合了Hystrix Dashboard 和 Turbine 聚合监控

项目启动前需要配置consul环境,以及application.yml文件中需要监控的微服务名称

项目启动后,浏览器地址栏键入: 

`localhost:8030/hystrix`

即可看到Hystrix dashboard 主页

URL一栏中输入

`localhost:8030/turbine.stream`

即可查看到聚合监控的微服务Hystrix熔断情况

如界面空白,则需自行调用测试接口

`localhost:8081/testFeign`
`localhost:8081/testConsul`

这两个接口位于backend项目中,连接了test项目进行测试
