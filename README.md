## TDD 공부 Repository

테스트 주도 개발 시작하기 책으로 TDD 수터디중
관련 내용 정리 진행

### 준비 
TDD를 위한 다양한 도구가 존재하는데 자바에서는 주로 Junit을 사용한다. (Junit5)
pom파일에 junit 의존성 추가
```
...
<!-- junit-jupiter 의존을 test 범위로 추가한다. -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.5.0</version>
    <scope>test</scope>
</dependency>
...
<!-- 2.22.0부터 junit5지원 -->
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.1</version>
</plugin>
...
```

### TDD란?
- 테스트 부터 시작. 그 다음에 구현
- 테스트를 먼저한다 = 기능이 올바르게 동작하는지 검증하는 테스트 코드를 작성한다는 것을 의미
- 이 테스트를 통과 시키기 위해 개발을 진행한다.

-> 테스트를 먼저 작성하고 테스트에 실패하면 테스트를 통과 시킬만큼 코드를 추가하는 과정을 반복하면서 점진적으로 기능을 완성해 나감


**테스트 작성** 
- 첫번째 테스트를 선택할 때에는 가장 쉽거나 가장 예외적인 상황을 선택해야함
- 테스트 -> 코딩 -> 리펙토링 -> 테스트 반복.. (레드-그린-리펙터)
- TDD는 기능을 검증하는 테스트를 먼저 작성. 통과 못하면 통과 만큼만 코드 작성. 테스트 통과 뒤 리펙토링 반복 기능완성 

