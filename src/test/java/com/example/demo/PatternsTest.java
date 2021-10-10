package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatternsTest {
    Patterns patterns = new Patterns();

    @Test
    void getPattern() {
        assert patterns.getPattern(0) == 0;
        assert patterns.getPattern(1) == 1;
        assert patterns.getPattern(2) == 2;
        assert patterns.getPattern(3) == 3;
        assert patterns.getPattern(4) == 4;
        assert patterns.getPattern(5) == 5;
        assert patterns.getPattern(6) == 6;

    }
}