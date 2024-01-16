package com.example.ctdd.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpiryDateCalculatorTest {
    /**
     * 매달 비용을 지불해야 사용 가능 유료서비스. 규칙에 따른 서비스 만료일 결정
     * 1. 사용하려면 매달 선불 납부 필요 납부일 기준 한달 뒤가 서비스 만료일
     * 2. 2개월 이상 요금을 납부할 수 있음
     * 3. 10만원을 납부하면 서비스를 1년 제공
     * -> 납부 금액 기준 서비스 만료일 계산
     */

    // 구현 쉬운것 부터 먼저 테스트
    // 예외 상황부터 먼저 테스트

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(LocalDate.of(2019,3,1), 10_000,
                LocalDate.of(2019,4,1));

        assertExpiryDate(LocalDate.of(2019,5,5), 10_000,
                LocalDate.of(2019,6,5));
    }

    private static void assertExpiryDate(
            LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
