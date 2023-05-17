package com.example.ctdd.chap01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    void substring() {
        String str = "abcde";
        System.out.println(str.substring(2,4));
        assertEquals("cd", str.substring(2,4));
    }
}
