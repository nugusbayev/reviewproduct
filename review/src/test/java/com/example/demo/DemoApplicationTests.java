package com.example.demo;

import com.example.demo.exception.ReviewNotFoundException;
import com.example.demo.model.CurrentUser;
import com.example.demo.repository.ReviewRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {

    }
}
