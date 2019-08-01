package com.example.vtd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name = "bean2")
    @Scope("")
    public HelloClazz getHelloBean() {
        HelloClazz bean =new HelloClazz();
        bean.setMsg("xin chao anh Dinh");
        return bean;
    }
}
