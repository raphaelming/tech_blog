package com.raphael.blog.techblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.raphael.blog.*")
public class TechblogApplication  {


    public static void main(String[] args) {
        SpringApplication.run(TechblogApplication.class, args);
    }
}
