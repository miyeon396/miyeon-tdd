package com.example.ctdd.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    // src/test/java 소스 폴더는 배포 대상이 아니므로 해당 폴더에 코드를 만들면 완성되지 않은 코드가 배포되는 것을 방지하는 효과가 있다.

    @Test
    void plus() {
        int sum = Calculator.plus(1,2);
        assertEquals(3, sum);
        assertEquals(5, Calculator.plus(4,1));
        // assertEquals메서드는 인자로 받은 두 값이 동일한지 비교
        // 첫번째 인자는 기대 값, 두번쨰 인자는 실제 값
        // 기대한 값과 실제 값이 동일한지 비교 후 동일하지 않으면 AssertionFailedError가 발생
    }
}
