package com.hendisantika.springbootmockmvcvuejs;

import com.hendisantika.springbootmockmvcvuejs.model.StockData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringbootMockmvcVuejsApplication implements CommandLineRunner {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMockmvcVuejsApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        logger.info("Initialize data...");
        StockData.INSTANCE.initData();
    }
}
