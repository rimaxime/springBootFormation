package com.example;

import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercice3Application {

    private static TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        Exercice3Application.testService = testService;
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Exercice3Application.class, args);
        testService.testMethod("Hello World", 50);
    }


}
