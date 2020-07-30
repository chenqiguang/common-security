package com.common.cn.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.common.cn")
@SpringBootApplication
public class CommonSecurityApplication  {
    public static void main(String[] args) {
        SpringApplication.run(CommonSecurityApplication.class, args);
    }
}
