package com.example.ctdd.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    void meetsAllCriteria_Then_Strong() {
        // 첫번째 테스트를 만들자
        // 첫번째 테스트를 선택할 때에는 가장 쉽거나 가장 예외적인 상황을 선택해야한다. -> ex) 모든 규칙 충족, 모든 조건 충족 X
        // -> 모든 규칙 충족으로 (이유는 각 조건 검사 코드 안만들고 강함만 리턴하면 되니 테스트 쉽게 통과 가능)

        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    //두번째 테스트
    // 길이만 8글자 미만이고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {

        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    // 세번째 테스트
    // 숫자를 포함하지 않고 나머지 조건은 충족하는 암호. 보통 강도
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);

    }
}
