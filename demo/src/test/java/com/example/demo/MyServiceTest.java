package com.example.demo;

import com.example.demo.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class MyServiceTest {

    @Autowired
    MyService myService;

    @Test
    void testConfigs(){
        assertFalse(myService.getCars().isEmpty());
        assertFalse(myService.getName().isEmpty());
        assertFalse(myService.getNumbers().isEmpty());
    }

}
