package com.xiuxian.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.xiuxian")
@EnableFeignClients(basePackages = "com.xiuxian.gateway.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class    XiuxianGatewayApplication{

    public static void main(String[] args) {
        SpringApplication.run(XiuxianGatewayApplication.class, args);
    }

}
