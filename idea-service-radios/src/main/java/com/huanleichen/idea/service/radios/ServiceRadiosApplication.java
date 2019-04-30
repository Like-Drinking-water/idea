package com.huanleichen.idea.service.radios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.huanleichen.idea")
@EnableEurekaClient
@EnableSwagger2
@MapperScan(basePackages = "com.huanleichen.idea.common.service.mapper")
public class ServiceRadiosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRadiosApplication.class, args);
    }
}
