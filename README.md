##소프트웨어 공학 Mission 2

팀장: 신유나(C011107)

팀원: 조현지(C111181), 심민서(C111096)

----------------------------------------------------------------------------------------------
## 역할

신유나: 젠킨스 세팅 및 파이프라인 구축, Junit 테스트 코드(PerfomanceTest) 작성

조현지: SearchBook(), Search_bs() 함수 구현

심민서: Junit 테스트 코드(BookTest) 작성

----------------------------------------------------------------------------------------------

## git 프로젝트 
프로젝트 원격 저장소 주소: https://github.com/youna3515/SW/tree/main

----------------------------------------------------------------------------------------------
## 오류
### Github 에러
1. 병합 충돌 오류

[원인] 원격 저장소의 branch로부터 로컬 branch를 새로 생성한뒤 Fetch하여, main이 Source로 지정되지 않음.

[해결 방안] 원격 저장소의 branch로 checkout 후 수정 및 Fetch함.

2.Pull 실패
![image](https://github.com/youna3515/SW/assets/87520237/29c203b2-0716-4af8-8353-beb3fda81b99)
![image](https://github.com/youna3515/SW/assets/87520237/8ca55fb9-646e-495b-95ca-181d164542fb)


[원인] 로컬 저장소에 메타데이터나 구조가 손상되었던 것으로 추정됨.

[해결 방안] garbage collection과 clean 후 다시 Pull함.

### Jenkins 에러
1.symbol을 찾을 수 없음 오류

![image](https://github.com/youna3515/SW/assets/87520237/9bb47a6c-17ff-42a0-b309-ca9f7f7b5f87)

[원인] Jorg.junit.jupiter.api 패키지에 있는 클래스들과 메서드를 찾지 못하고 있는 것으로 추정됨. 즉, 파일 구조가 잘못됨.

[해결 방안]  junit-platform-console-standalone-1.7.1.jar 파일을 lib/폴더 하위에 추가함.

2.flag 오류

![image](https://github.com/youna3515/SW/assets/87520237/356766ae-9fc9-4496-be65-838e28bc867a)

[원인] Jjavac 명령어가 여러 JAR 파일을 classpath에 포함함.

[해결 방안] -classpath 옵션을 사용하고, 각 JAR 파일 경로를 구분자로 구분하여 나열함.

3. test 실패
   
Failures (1):
  JUnit Jupiter:BookTest:testAddBook()
    MethodSource [className = 'BookTest', methodName = 'testAddBook', methodParameterTypes = '']
    => org.opentest4j.AssertionFailedError: expected: <true> but was: <false>
       org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:55)
       org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:40)
       org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:35)
       org.junit.jupiter.api.Assertions.assertTrue(Assertions.java:162)
       BookTest.testAddBook(BookTest.java:18)
       java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
       java.base/java.lang.reflect.Method.invoke(Method.java:580)
       org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:688)
       org.junit.jupiter.engine.execution.MethodInvocation.proceed(MethodInvocation.java:60)
       org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:131)
       [...]

[원인] assertTrue 함수에서 False를 반환받음. Eclipse에서는 BookTest와 PerformanceTest를 한 번씩 구동하여 오류가 없었으나, Jenkins에서는 둘을 랜덤한 순서로 구동하므로, 이미 있는 Book에 대하여 add를 수행하는 등 오류가 발생함.

[해결 방안]  assertTrue(Book.AddBook(book1)); 를 하기 전 해당 인스턴스의 remove함수를 호출하는 등 기대와 다른 결과를 반환받지 않도록 테스트 코드를 수정함.
