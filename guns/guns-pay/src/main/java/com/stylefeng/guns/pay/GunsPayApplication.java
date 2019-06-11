package com.stylefeng.guns.pay;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stylefeng.guns"})
@EnableDubboConfiguration
@MapperScan(basePackages = "com.stylefeng.guns.pay.modular.payservice.mapper")
public class GunsPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GunsPayApplication.class, args);
    }
}
