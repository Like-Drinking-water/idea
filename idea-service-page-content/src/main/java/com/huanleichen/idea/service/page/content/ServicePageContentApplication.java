package com.huanleichen.idea.service.page.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.huanleichen.idea")
@MapperScan(basePackages = "com.huanleichen.idea.common.service.mapper")
public class ServicePageContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePageContentApplication.class, args);
    }
}
