package com.stylefeng.guns.rest;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
@EnableDubboConfig
@MapperScan(basePackages = "com.stylefeng.guns.rest.modular.user.mapper")
public class GunsRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsRestApplication.class, args);
    }
}
