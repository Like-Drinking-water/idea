package com.huanleichen.idea.service.posts.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.huanleichen.idea")
@EnableSwagger2
@EnableEurekaClient
@MapperScan(basePackages = "com.huanleichen.idea.common.service.mapper")
public class ServicePostsSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePostsSearchApplication.class, args);
    }
}
