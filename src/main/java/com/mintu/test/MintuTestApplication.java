package com.mintu.test;

import cn.hutool.core.lang.Snowflake;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MintuTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MintuTestApplication.class, args);
    }

    @Bean
    public Snowflake snowflake(){
        return new Snowflake();
    }
}
