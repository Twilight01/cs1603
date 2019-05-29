package com.cs1603.jwglxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication


@MapperScan("com.cs1603.jwglxt.mapper")
public class JwglxtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwglxtApplication.class, args);
    }

}
