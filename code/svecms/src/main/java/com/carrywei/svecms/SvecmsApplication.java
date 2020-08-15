package com.carrywei.svecms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.carrywei.svecms.mapper.plus")
public class SvecmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvecmsApplication.class, args);
    }

}
