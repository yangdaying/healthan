package com.health.app;

import com.health.app.bean.Employee;
import com.health.app.dao.EmployeeRepository;
import com.health.app.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MyApplication {
    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }


    @Bean
    public SnowflakeIdWorker getBean(){
        return new SnowflakeIdWorker(1,1);
    }


}
