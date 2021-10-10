package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppTest {

    App app = new App();

    @Test
    void getRandomPatternNumber() {
        assert app.getRandomPatternNumber() >= 0 && app.getRandomPatternNumber() <= 6;
    }
}