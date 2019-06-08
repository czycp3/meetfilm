package com.stylefeng.guns.pay;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
@EnableDubboConfiguration
public class GunsPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsPayApplication.class, args);
    }
}