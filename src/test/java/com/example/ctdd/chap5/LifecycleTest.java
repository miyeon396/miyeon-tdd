package com.example.ctdd.chap5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleTest {
    public LifecycleTest() {
        System.out.println("new LifecycleTest");
    }

    @BeforeEach //private이면 안됨. 테스트 실행하는데 필요한 준비 작업시 사용
    void setUp() {
        System.out.println("setUp");
    }

    @Test
    void a() {
        System.out.println("A");
    }

    @Test
    void b() {
        System.out.println("B");
    }

    @AfterEach //private이면 안됨. 테스트 실행 후 정리한 것이 있을 때 사용
    void tearDown() {
        System.out.println("tearDown");
    }
}
