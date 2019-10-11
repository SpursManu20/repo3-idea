package com.manu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient
//@EnableCircuitBreaker   //服务的熔断
//@SpringBootApplication

@EnableFeignClients
@SpringCloudApplication //其中包含了上面三个注解
public class ConsumerApplication {

//    @Bean
//    @LoadBalanced   //内置拦截器，拦截restTemplate请求
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }
}
