package com.huanleichen.idea.service.posts.commit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.huanleichen.idea")
@EnableEurekaClient
@MapperScan(basePackages = "com.huanleichen.idea.common.service.mapper")
public class ServicePostsCommitApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePostsCommitApplication.class, args);
    }
}
