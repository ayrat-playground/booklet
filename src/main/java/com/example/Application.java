package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.example.booklet.models.Link;
import com.example.booklet.repositories.*;

@SpringBootApplication
public class Application {
    private static LinkRepository repo;
    
    @Autowired
    public Application(LinkRepository repo) {
        Application.repo = repo;
    }

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}
