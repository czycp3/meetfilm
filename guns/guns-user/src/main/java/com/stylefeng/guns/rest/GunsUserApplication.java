package com.stylefeng.guns.rest;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
@EnableDubboConfiguration
@MapperScan(basePackages = "com.stylefeng.guns.rest.modular.user.mapper")
public class GunsUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(GunsUserApplication.class, args);
    }
}
