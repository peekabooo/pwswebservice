package com.pws.pwswebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class PwswebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PwswebserviceApplication.class, args);
    }
}
