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

    // 네번째 테스트
    // 값이 없는 경우
    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    // 다섯번째 테스트
    // 대문자를 포함하지 않고 나머지 조건을 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    // 여섯번째 테스트
    // 길이가 8글자 이상인 조건만 충족하는 경우
    // 이제 남은 것은 한가지 조건만 충족하거나 모든 조건을 충족하지 않는 경우
    // 한가지만 충족 -> 약함
    @Test
    void meetsOnlyLengthCreteria_Then_Weak() {
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    // 일곱번째 테스트
    // 숫자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    // 여덟번째 테스트
    // 대문자 포함 조건만 충족하는 경우
    @Test
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }
}
