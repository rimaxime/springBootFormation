package com.example.service;

import com.example.annotation.LogMethod;
import org.springframework.stereotype.Service;

/**
 * Created by rivie on 11/04/2017.
 */
@Service
public class TestService {
    @LogMethod("test Method")
    public void testMethod(String message, int sleepTime) throws InterruptedException {
        Thread.sleep(sleepTime);
    }
}
