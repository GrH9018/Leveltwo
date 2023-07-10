# Leveltwo

API 명세서

https://satin-argument-285.notion.site/476a448ba995410cb96dcebdb03a88cd?v=d1c46c895b5a4154a0742383b9abb3c1

ERD 설계

![ERD 설계](https://github.com/GrH9018/Leveltwo/assets/133674570/5730ca1c-c28b-4344-9a88-d13518102085)


<aside>
💡 **코드 컨벤션 - 함께 협업하기 위해, 어떤 규칙을 정했나요?**
(예시) 변수명은 CamelCase로 한다.

</aside>

- 

<aside>
💡 **역할 분배 - 이번 과제의 역할 분배를 어떻게 했나요?**
(예시) 게시글 삭제 기능 - 선겸, 게시글 수정 기능 - 예지

</aside>

- 

<aside>
💡 **내 페어(페어팀 X)**와 **함께 답변을 적어 제출해주세요.**

</aside>

1. 처음 설계한 API 명세서에 변경사항이 있었나요? 
변경 되었다면 어떤 점 때문 일까요? 첫 설계의 중요성에 대해 작성해 주세요!
    
    ```
    
    ```
    
2. ERD를 먼저 설계한 후 Entity를 개발했을 때 어떤 점이 도움이 되셨나요?
    
    ```
    
    ```
    
3. JWT를 사용하여 인증/인가를 구현 했을 때의 장점은 무엇일까요?
    JWT 장점
        데이터의 위변조를 방지한다.
        JWT는 인증에 필요한 모든 정보를 담고 있기 때문에 인증을 위한 별도의 저장소가 없어도 된다.
        확장성이 우수하다.
    
4. 반대로 JWT를 사용한 인증/인가의 한계점은 무엇일까요?
    JWT 단점
        쿠키/세션과 다르게 토큰의 길이가 길어, 인증 요청이 많아질수록 네트워크 부하가 심해진다.
        Payload 자체는 암호화가 되지 않아 중요한 정보는 담을 수 없다.
        토큰을 탈취당한다면 대처가 매우 어렵다.
    
5. 만약 댓글 기능이 있는 블로그에서 댓글이 달려있는 게시글을 삭제하려고 한다면 무슨 문제가 발생할까요? Database 테이블 관점에서 해결방법이 무엇일까요?
     게시글에 달려있는 댓글도 게시글을 삭제할 때 동시에 삭제해야 한다.
    
6. IoC / DI 에 대해 간략하게 설명해 주세요! 
    IoC 란?
        Inversion of Control 의 줄임말로, 제어의 역전 이라는 뜻이 된다. 제어의 역전이란 메소드나 객체의 호출작업을 개발자가 아닌 외부에서 결정되는 것을 의미한다.

   DI 란?
        Dependency Injection 의 줄임말로, 의존성 주입 이라는 뜻이 된다. 의존성 주입은 제어의 역전이 일어날때 스프링 내부에 있는 객체들간의 관계를 관리할 때 사용하는 기법이다. 
