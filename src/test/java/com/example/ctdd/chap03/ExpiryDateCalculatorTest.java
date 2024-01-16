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
        LocalDate billingDate = LocalDate.of(2019,3,1);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertEquals(LocalDate.of(2019,4,1), expiryDate);

        LocalDate billingDate2 = LocalDate.of(2019,5,5);
        int payAmount2 = 10_000;

        ExpiryDateCalculator cal2 = new ExpiryDateCalculator();
        LocalDate expiryDate2 = cal2.calculateExpiryDate(billingDate2, payAmount2);

        assertEquals(LocalDate.of(2019,6,5), expiryDate2);
    }
}
