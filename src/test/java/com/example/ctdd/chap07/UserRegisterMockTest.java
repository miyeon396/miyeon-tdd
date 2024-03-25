package com.example.ctdd.chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegisterMockTest {
    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifiler mockEmailNotifiler = Mockito.mock(EmailNotifiler.class);


    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifiler);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true); //모의 객체를 이용하여 스텁을 대신함
        // pw 인자 사용해서 모의객체의 checkPasswordWeak메서드 호출 시 true를 결과로 리턴하라

        assertThrows(WeakPasswordException.class, () ->  {
            userRegister.register("id", "pw", "email");
        });
    }

    @DisplayName("회원 가입 시 암호 검사 수행함")
    @Test
    void checkPassword() {
        userRegister.register("id", "pw", "email");

        BDDMockito.then(mockPasswordChecker) //인자로 전달한 mockPasswordChecker 모의객체의
                .should() // 특정 메서드가 호출됏는지 검사하는데
                .checkPasswordWeak(BDDMockito.anyString()); // 임의의 String 타입의 인자를 이용해서 checkPasswordWeak() 호출 여부를 확인한다.


    }

    //모의객체를 사용하면 스파이(기록)도 가능하다.
    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@email.com");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); //ArgumentCaptor#capture() 메서드 사용시 메서드를 호출할 때 전달한 인자가 ArgumentCaptor에 담긴다.
        BDDMockito.then(mockEmailNotifiler)
                .should()
                .sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue(); //captor.getValue()로 보관한 인자를 구할 수 있다.
        assertEquals("email@email.com", realEmail);

    }
}
