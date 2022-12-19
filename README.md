2022.12.14 ~
# springStudyBasic
스프링 핵심 원리-기본편

### 스프링이란?
스프링에서 지원
<img width="538" alt="스크린샷 2022-12-14 오후 2 42 54" src="https://user-images.githubusercontent.com/96857599/207515594-f04dffb0-d6ff-4d07-b78d-6f46ca8d73be.png">

- 스프링 프레임워크
<img width="535" alt="스크린샷 2022-12-14 오후 2 42 25" src="https://user-images.githubusercontent.com/96857599/207515510-8efba835-ec80-4494-adff-46d272477c18.png">

- 스프링 부트
<img width="518" alt="스크린샷 2022-12-14 오후 2 44 02" src="https://user-images.githubusercontent.com/96857599/207515758-3c53c601-b25e-43ec-88d5-cf084f799494.png">


예전에는 Tomcat 같은 서버를 따로 빌드하고 설정하는 것이 복잡했지만, 스프링부트를 이용하면 간결해짐.
예전에는 외부 라이브러리와의 버전 궁합에 대해 어려움을 겪었지만, 스프링부트가 알아서 해줌.

- 스프링이라는 단어는 무엇을 의미하는가?
1. 스프링 DI 컨테이너 기술
2. 스프링 프레임워크
3. 스프링 부트, 스프링 프레임워크 등을 모두 포함한 스프링 생태계

- 스프링을 왜 만들었을까?

1. 스프링의 핵심
- 스프링은 자바 언어 기반의 프레임워크
- 자바 언어의 가장 큰 특징 - 객체 지향 언어
- 스프링은 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크
- 스프링은 좋은 객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크이다.

### 좋은 객체 지향 프로그래밍이란?
- 인터페이스가 바뀌는 일이 없도로 안정적으로 잘 설계하는 것이 중요함
<img width="554" alt="스크린샷 2022-12-15 오후 10 06 24" src="https://user-images.githubusercontent.com/96857599/207866882-bde63eb0-c6a7-4bfc-80aa-a42a93179377.png">
- 객체 지향의 꽃은 다형성이다.<img width="1299" alt="스크린샷 2022-12-18 오후 3 32 07" src="https://user-images.githubusercontent.com/96857599/208284887-5ac5ae8c-6799-4458-b7f4-fc258dde1db9.png">

- 스프링은 다형성을 극대화해서 이용하게 해준다.
- 스프링에서 이야기하는 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용해서 역할과 구현으 편리하게 다룰 수 있도록 지원한다.
- 스프링을 사용하면 마치 레고 블러 조립하듯, 공연 무대 배우를 선택하듯, 구현을 편리하게 변경할 수 있다.

 
### 좋은 객체 지향 설계의 5가지 원칙(SOLID)
1. SRP 단일 책임 원칙 Single responsibility principle
 
- 한 클래스는 하나의 책임만 가져야 한다. 
- 하나의 책임이라는 것은 모호하다.
 - 클 수 있고, 작을 수 있다.
 - 문맥과 상황에 따라 다르다.
- 중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것 
- 예) UI 변경, 객체의 생성과 사용을 분리

2. OCP 개방-폐쇄 원칙 Open/closed principle (가장 중요한 원칙)

- 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
- 이런 거짓말 같은 말이? 확장을 하려면, 당연히 기존 코드를 변경? 
- 다형성을 활용해보자
- 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현 
- 지금까지 배운 역할과 구현의 분리를 생각해보자
<img width="645" alt="스크린샷 2022-12-16 오후 1 55 28" src="https://user-images.githubusercontent.com/96857599/208025395-8f5bed75-0e48-4c17-b3cc-7087bb502302.png">

#### OCP 개방-폐쇄 원칙 문제점
- MemberService 클라이언트가 구현 클래스를 직접 선택
 - MemberRepository m = new MemoryMemberRepository(); //기존 코드
 - MemberRepository m = new JdbcMemberRepository(); //변경 코드 
- 구현 객체를 변경하려면 클라이언트 코드를 변경해야 한다.
- 분명 다형성을 사용했지만 OCP 원칙을 지킬 수 없다.
- 이 문제를 어떻게 해결해야 하나?
- 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다. (스프링 컨테이너의 역할)

3. LSP 리스코프 치환 원칙 Liskov substitution principle

- 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다
- 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것, 다형성을 지원하기 위 한 원칙, 인터페이스를 구현한 구현체는 믿고 사용하려면, 이 원칙이 필요하다.
- 단순히 컴파일에 성공하는 것을 넘어서는 이야기
- 예) 자동차 인터페이스의 엑셀은 앞으로 가라는 기능, 뒤로 가게 구현하면 LSP 위반, 느리더라도 앞으로 가야함

4. ISP 인터페이스 분리 원칙 Interface segregation principle

- 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다 
- 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리
- 사용자 클라이언트 -> 운전자 클라이언트, 정비사 클라이언트로 분리
- 분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에 영향을 주지 않음 
- 인터페이스가 명확해지고, 대체 가능성이 높아진다.

5. DIP 의존관계 역전 원칙 Dependency inversion principle(중요)

- 프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.” 의존성 주입은 이 원칙 을 따르는 방법 중 하나다.
- 쉽게 이야기해서 구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻
- 앞에서 이야기한 역할(Role)에 의존하게 해야 한다는 것과 같다. 객체 세상도 클라이언트 가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다! 구현체에 의존하게 되면 변경이 아주 어려워진다.

#### DIP 의존관계 역전 원칙 Dependency inversion principle

- 그런데 OCP에서 설명한 MemberService는 인터페이스에 의존하지만, 구현 클래스도 동시에 의존한다.
- MemberService 클라이언트가 구현 클래스를 직접 선택
- MemberRepository m = new MemoryMemberRepository();
- DIP 위반

#### 정리

- 객체 지향의 핵심은 다형성
- 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없다.
- 다형성 만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경된다. 다형성 만으로는 OCP, DIP를 지킬 수 없다.
- 뭔가 더 필요하다.(이후에 알아갈 내용)

### 객체 지향 설계와 스프링

- 스프링은 다음 기술로 다형성 + OCP,DIP를 가능하게 지원
 - DI(Dependency Injection): 의존관계, 의존성 주입
 - DI 컨테이너 제공
- 클라이언트 코드의 변경 없이 기능 확장 
- 쉽게 부품을 교체하듯이 개발


- 옛날 어떤 개발자가 좋은 객체 지향 개발을 하려고 OCP, DIP 원칙을 지키면서 개발을 해 보니, 너무 할일이 많았다. 배보다 배꼽이 크다. 그래서 프레임워크로 만들어버림
- 순수하게 자바로 OCP, DIP 원칙들을 지키면서 개발을 해보면, 결국 스프링 프레임워크를 만들게 된다. (더 정확히는 DI 컨테이너)
- DI 개념은 말로 설명해도 이해가 잘 안된다. 코드로 짜봐야 필요성을 알게된다! 
- 그러면 이제 스프링이 왜? 만들어졌는지 코드로 이해해보자

### 프로젝트 생성
1. Spring Initializr에서 스프링 생성
<img width="958" alt="스크린샷 2022-12-16 오후 2 29 38" src="https://user-images.githubusercontent.com/96857599/208028995-9eb8f072-1b4c-452c-89bc-74e9d854efed.png">
2. Preference에서 gradle 설정 변경 Buid and Run Using과 Run test using 설정을 모두 IntelliJ IDEA로 변경(실행시 더 빨라짐)
<img width="966" alt="스크린샷 2022-12-16 오후 2 28 59" src="https://user-images.githubusercontent.com/96857599/208029222-aaba1f73-1cff-4aa0-9552-0a3fbb88ffea.png">

### 비지니스 요구사항과 설계
<img width="881" alt="스크린샷 2022-12-16 오후 2 35 57" src="https://user-images.githubusercontent.com/96857599/208029656-380786fe-f59d-42bc-80e6-7f130450c5c4.png">

### 회원 도메인 설계

<img width="638" alt="스크린샷 2022-12-17 오후 3 53 27" src="https://user-images.githubusercontent.com/96857599/208229657-7bbd7708-40fb-467b-ae45-e508c9157f0c.png">


<img width="633" alt="스크린샷 2022-12-17 오후 3 53 45" src="https://user-images.githubusercontent.com/96857599/208229668-8741f591-c7fb-4dac-829d-7b29309303c4.png">

#### 회원 속성

1. member 패키지에 Grade 열거형 상수로 BASIC과 VIP를 입력한다.

<img width="900" alt="스크린샷 2022-12-17 오후 4 04 01" src="https://user-images.githubusercontent.com/96857599/208230090-aaa2374b-b834-40e0-872f-987f276f4f03.png">

2. member 패키지에 Member 클래스를 만들고, 각 속성의 생성자와 getter setter를 만들어준다.
<img width="1041" alt="스크린샷 2022-12-17 오후 4 07 38" src="https://user-images.githubusercontent.com/96857599/208230218-00dd6848-fe12-4c10-ba6f-3182a7cc33c9.png">

#### 회원 레포지토리

3. member 패키지에 MemberRepository 인터페이스를 만들어주고, save, findById 기능을 넣어준다.
<img width="1041" alt="스크린샷 2022-12-17 오후 4 12 21" src="https://user-images.githubusercontent.com/96857599/208230385-20955dbc-2a78-43e4-8022-9bc632068a5f.png">

4. MemberRepository 인터페이스와 다른 패키지에 생성하는 것이 좋지만 지금 예제에서느 복잡해지기 때문에 같은 member 패키지에 MemoryMemberRepository를 생성한다.(오류처리도 해야하지만, 예제이기 때문에 넘어감.)

<img width="1235" alt="스크린샷 2022-12-17 오후 4 22 11" src="https://user-images.githubusercontent.com/96857599/208230691-8b6985b7-eaff-4d23-aac3-e6543c4aba3a.png">

[HashTable, HashMap, concurrentHashMap에 대한 정리](https://devlog-wjdrbs96.tistory.com/269)

#### 회원 서비스

5. MemebrService 인터페이스를 만들어주고, 회원 가입, 회원 조회 기능을 넣어준다.

<img width="936" alt="스크린샷 2022-12-17 오후 4 29 29" src="https://user-images.githubusercontent.com/96857599/208230993-f72cc678-443a-4605-929e-e48d99b785bb.png">

6. MemberServiceImpl 구현 클래스를 만들고, MemberService 인터페이스르 구현해준다.(구현 클래스가 하나일 때 관례적으로 인터페이스 이름 뒤에 Impl을 붙여서 구현 클래스를 만든다.)

<img width="1145" alt="스크린샷 2022-12-17 오후 4 34 03" src="https://user-images.githubusercontent.com/96857599/208231166-6f0391cd-0263-4d3a-85bc-896ae7630595.png">

### 회원 도메인 실행과 테스트

1. MemberApp을 만들어 간단한 실행을 해본다. (권장하지 않는 방법) 

<img width="1127" alt="스크린샷 2022-12-17 오후 4 45 06" src="https://user-images.githubusercontent.com/96857599/208231564-d6125794-ea80-49dc-bac2-1f3bfa093747.png">

2. Junit을 이용한 테스트를 진행해본다.
<img width="1127" alt="스크린샷 2022-12-17 오후 4 54 25" src="https://user-images.githubusercontent.com/96857599/208231910-df015b8d-ace1-460d-b53c-fa6756af5edc.png">

#### 회원 도메인 설계의 문제점
- 이 코드의 설계상 문제점은 무엇일까요?
- 다른 저장소로 변경할 때 OCP 원칙을 잘 준수할까요?
- DIP를 잘 지키고 있을까요?
- 의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있음
<img width="692" alt="스크린샷 2022-12-17 오후 4 59 29" src="https://user-images.githubusercontent.com/96857599/208232071-2e944ee2-d76d-4966-be95-c8b2a74edf61.png">
이 경우만 해도 MemberRepository라는 인터페이스와 MemoryMemberRepository라는 구현체 모두를 의존하고 있기 때문에 인터페이스만 의존했을 때 지켜지는 DIP원칙은 물론 OCP원칙도 지키지 못하고 있다.


### 주문과 할인 도메인 설계

<img width="685" alt="스크린샷 2022-12-17 오후 5 33 52" src="https://user-images.githubusercontent.com/96857599/208233403-bd43be4f-84cb-4390-bac0-09db6bbb06d2.png">

<img width="683" alt="스크린샷 2022-12-17 오후 5 34 21" src="https://user-images.githubusercontent.com/96857599/208233417-fb300e26-209d-41db-a29d-1e78d765708e.png">

<img width="685" alt="스크린샷 2022-12-17 오후 5 34 50" src="https://user-images.githubusercontent.com/96857599/208233437-1541b4b0-2028-4648-b2fd-78f1b3d34e5a.png">

- 주문 도메인 클래스 다이어그램
<img width="685" alt="스크린샷 2022-12-17 오후 5 35 31" src="https://user-images.githubusercontent.com/96857599/208233454-d593ce27-3f39-4699-abb3-58193f5518b0.png">

<img width="684" alt="스크린샷 2022-12-17 오후 5 35 46" src="https://user-images.githubusercontent.com/96857599/208233462-2ba85d7b-d9ee-4d73-a452-eeb920684079.png">

<img width="684" alt="스크린샷 2022-12-17 오후 5 36 06" src="https://user-images.githubusercontent.com/96857599/208233470-d4d5b935-fbc5-4997-b313-0e07384f8471.png">

## 설계된 클래스를 가장 깊숙한 곳부터 개발했음.

### 주문과 할인 도메인 개발

1. 할인 정책 인터페이스 설정

<img width="911" alt="스크린샷 2022-12-18 오후 1 27 14" src="https://user-images.githubusercontent.com/96857599/208281483-6227bf9a-7372-4a15-993e-513546bbacd9.png">

2. 정액 할인 정책 구현체

<img width="987" alt="스크린샷 2022-12-18 오후 1 31 36" src="https://user-images.githubusercontent.com/96857599/208281588-945a78f4-249f-4eb9-a108-6267717427d1.png">

3. order 패키지와 Order 클래스 생성 후, 생성자, getter setter 세팅 및 할인 가격 계산 메소드 생성
<img width="1041" alt="스크린샷 2022-12-18 오후 2 25 50" src="https://user-images.githubusercontent.com/96857599/208282968-11ba4b5f-e0bb-4d09-8833-0ad46319cc71.png">

4. 보기 쉽게 하기 위해 toString()
<img width="491" alt="스크린샷 2022-12-18 오후 2 27 31" src="https://user-images.githubusercontent.com/96857599/208283017-05155fc4-01b8-4705-9000-ee9679f00eae.png">

<img width="508" alt="스크린샷 2022-12-18 오후 2 27 47" src="https://user-images.githubusercontent.com/96857599/208283025-a42fbcfe-7ce9-4aed-90d0-0bd91d65edd0.png">

5. 주문서비스 인터페이스 생성
<img width="1041" alt="스크린샷 2022-12-18 오후 2 30 58" src="https://user-images.githubusercontent.com/96857599/208283097-493cd10e-b454-4fbd-aca3-2d887dc877c6.png">

6. 주문서비스 구현

<img width="1270" alt="스크린샷 2022-12-18 오후 3 33 49" src="https://user-images.githubusercontent.com/96857599/208284910-80404c77-8ac4-4bea-aedf-222263ed57d5.png">

### 주문과 할인 도메인 실행과 테스트

1. OrderApp으로 order 실행테스트

<img width="1100" alt="스크린샷 2022-12-18 오후 7 45 39" src="https://user-images.githubusercontent.com/96857599/208294048-72fa8279-c755-4c71-8787-a3df80b137f6.png">

2. Junit으로 테스트

<img width="1332" alt="스크린샷 2022-12-18 오후 8 05 22" src="https://user-images.githubusercontent.com/96857599/208294853-9b38b60e-809a-4c30-bac2-4eda340bece1.png">

#### 클라이언트가 주문서비스에 주문 생성을 하고, 회원 조회와 할인으 적용하는 것까지의 결과를 반환했다. 다음에는 정률 할인 정책으로 바꾸었을 때 깔끔하게 바꿀 수 있는지 확인할 것이다.

### 새로운 할인 정책 개발

<img width="641" alt="스크린샷 2022-12-18 오후 8 11 56" src="https://user-images.githubusercontent.com/96857599/208295104-3f050dd6-49f7-4597-85d5-cb73d6e1ca52.png">

1. 정률 할인 정책 클래스 생성 및 테스트 생성

<img width="954" alt="스크린샷 2022-12-18 오후 8 17 45" src="https://user-images.githubusercontent.com/96857599/208295379-c10bfcb9-388d-4ef1-ab0d-b7473e049d52.png">

cmd + shift + T로 테스트 생성

- 성공 테스트

<img width="1199" alt="스크린샷 2022-12-18 오후 8 21 21" src="https://user-images.githubusercontent.com/96857599/208295527-7dd531b0-ca4b-49c1-84af-d82893716ae7.png">

- 실패 테스트

<img width="1199" alt="스크린샷 2022-12-18 오후 8 24 05" src="https://user-images.githubusercontent.com/96857599/208295675-2274210a-5d2a-4521-9ad0-41428d59dfb9.png">

- 동시 테스트

<img width="1199" alt="스크린샷 2022-12-18 오후 8 25 08" src="https://user-images.githubusercontent.com/96857599/208295738-0af59391-4ebc-4c18-aae4-7908cbbfc43c.png">

- 원래 할인 정책에 대한 테스트는 실무에서 경계값을 모두 테스트 해볼 정도로 어려운 테스트이지만 지금은 예제로 공부하는 상태이고, 객체지향적인 코드를 만들었기 때문에 간단하게 할 수 있었다.

<img width="561" alt="스크린샷 2022-12-18 오후 8 27 33" src="https://user-images.githubusercontent.com/96857599/208295831-5ac95238-9f73-4a4f-9b56-fe3bfd18e64c.png">

이렇게 간단하지 않다..

### 새로운 할인 정책 적용과 문제점

새로운 할인 정책인 정률 할인 정책을 OrderServiceImpl에 적용해본다.
<img width="1207" alt="스크린샷 2022-12-18 오후 8 29 53" src="https://user-images.githubusercontent.com/96857599/208295924-9d79b39b-31d0-42f1-ba72-ede50ebf6146.png">

문제점 발견
- 우리는 역할과 구현을 충실하게 분리했다. -> OK
- 다형성도 활용하고, 인터페이스와 구현 객체를 분리했다. -> OK 
- OCP, DIP 같은 객체지향 설계 원칙을 충실히 준수했다?
   -> 그렇게 보이지만 사실은 아니다.
- DIP: 주문서비스 클라이언트( OrderServiceImpl )는 DiscountPolicy 인터페이스에 의존하면서 DIP를 지킨 것 같은데?
   -> 클래스 의존관계를 분석해 보자. 추상(인터페이스) 뿐만 아니라 구체(구현) 클래스에도 의존하고 있다.
      - 추상(인터페이스) 의존: DiscountPolicy
      - 구체(구현) 클래스: FixDiscountPolicy , RateDiscountPolicy 

<img width="628" alt="스크린샷 2022-12-18 오후 8 37 43" src="https://user-images.githubusercontent.com/96857599/208296234-3eed8475-9b7f-4969-95b9-0185da13406b.png">


<img width="640" alt="스크린샷 2022-12-18 오후 8 35 47" src="https://user-images.githubusercontent.com/96857599/208296163-3ff71114-0d4a-43c5-bfba-333fdaab6d5e.png">

또한, 할인 정책을 변경하는 순간

<img width="615" alt="스크린샷 2022-12-18 오후 8 38 13" src="https://user-images.githubusercontent.com/96857599/208296258-1612534d-667b-4f2f-8b7b-23c6f6d07c2a.png">

<img width="641" alt="스크린샷 2022-12-18 오후 8 38 33" src="https://user-images.githubusercontent.com/96857599/208296271-8e7275a2-1428-4443-bfa6-d18090bfe49c.png">

- OCP: 변경하지 않고 확장할 수 있다고 했는데!
   -> 지금 코드는 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 준다! 따라서 OCP를 위반한다.

## 어떻게 문제를 해결할 수 있을까?

- 클라이언트 코드인 OrderServiceImpl은 DiscountPolicy의 인터페이스 뿐만 아니라 구체 클래스도 함께 의존한다.
- 그래서 구체 클래스를 변경할 때 클라이언트 코드도 함께 변경해야 한다.
- DIP 위반 -> 추상에만 의존하도록 변경(인터페이스에만 의존)
- DIP를 위반하지 않도록 인터페이스에만 의존하도록 의존관계를 변경하면 된다.

- 인터페이스에만 의존하도록 설계를 변경하자.

<img width="639" alt="스크린샷 2022-12-18 오후 8 40 47" src="https://user-images.githubusercontent.com/96857599/208296357-0870a75d-626d-47c3-b8ac-803ab0d84e36.png">

<img width="755" alt="스크린샷 2022-12-18 오후 8 42 01" src="https://user-images.githubusercontent.com/96857599/208296409-170be7a9-d07c-4fe3-bab5-284155cbad2e.png">

- 인터페이스에만 의존하도록 설계와 코드를 변경했다.
- 그런데 구현체가 없는데 어떻게 코드를 실행할 수 있을까?
- 실제 실행을 해보면 NPE(null pointer exception)가 발생한다. -> 당연하게도 discountPolicy는 현재 인터페이스이므로 비어있다.
<img width="1258" alt="스크린샷 2022-12-18 오후 8 44 15" src="https://user-images.githubusercontent.com/96857599/208296487-42fe98ce-5d0c-4157-93d4-ade4583de0f1.png">

#### 해결방안

- 이 문제를 해결하려면 누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해주어야 한다.

### 관심사의 분리

#### AppConfig 등장

애플리케이션의 전체 동작 방식을 구성(config)하기 위해, **구현 객체를 생성**하고, **연결**하는 책임을 가지는 별도의 설정 클래스를 만들자.

#### MemberServiceImpl에서 MemberRepository를 바로 MemoryMemberRepository로 지정하는 것이 아니라, 생성자를 만들고, AppConfig에서 설정하도록 변경한다. 즉, AppConfig에서 어떤 구현체를 사용할지 정할 수 있도록 바꾸고, MemberServiceImpl같은 클라이언트가 직접 구현 클래스를 의존하는 것을 막고 연결시키는 것이다.

- AppConfig에서 MemberService가 사용할 repository를 설정할 수 있도록 한다.
<img width="1364" alt="스크린샷 2022-12-18 오후 8 51 52" src="https://user-images.githubusercontent.com/96857599/208296819-6e6dd87a-4a4d-48f6-9f8b-df2b5f17c426.png">

- 구현체와의 직접 연결을 끊고 생성자를 만든다.
<img width="1305" alt="스크린샷 2022-12-18 오후 8 55 36" src="https://user-images.githubusercontent.com/96857599/208296984-c3b95eeb-15b5-4be5-b69c-c879560ab728.png">

- AppConfig에서 MemberService와 MemoryMemberRepository를 연결해준다.
<img width="1430" alt="스크린샷 2022-12-18 오후 9 13 00" src="https://user-images.githubusercontent.com/96857599/208297714-63ed2480-c409-457e-8519-a772ae892389.png">

#### 마찬가지로 OrderServiceImpl도 바꾸어준다.

- AppConfig에서 OrderService가 사용할 repository와 할인 정책을 설정할 수 있도록 한다.
<img width="1430" alt="스크린샷 2022-12-18 오후 9 11 15" src="https://user-images.githubusercontent.com/96857599/208297645-1aedb884-8c2b-4a4f-92fe-d65537ad65cd.png">

- 구현체와의 직접 연결을 끊고 생성자를 만든다.
<img width="1430" alt="스크린샷 2022-12-18 오후 9 11 35" src="https://user-images.githubusercontent.com/96857599/208297657-34e4dc0c-cd9b-48ca-b59a-ef05174eafb8.png">

- AppConfig에서 OrderService와 MemoryMemberRepository, RateDiscountPolicy를 연결해준다.
<img width="1430" alt="스크린샷 2022-12-18 오후 9 11 47" src="https://user-images.githubusercontent.com/96857599/208297661-98a6a4cf-bb3d-4298-89ee-3ffc1b5ef7c2.png">

그림 - 클래스 다이어그램

<img width="641" alt="스크린샷 2022-12-18 오후 9 48 00" src="https://user-images.githubusercontent.com/96857599/208299209-b236fbae-9d31-4bd2-9bc4-95c41921cfce.png">

그림 - 회원 객체 인스턴스 다이어그램
<img width="640" alt="스크린샷 2022-12-18 오후 9 48 45" src="https://user-images.githubusercontent.com/96857599/208299262-ea277d89-84bf-4d98-8bcd-373f4183c1bc.png">

#### main 클래스 테스트 DI 변경 후 실행

- MemberApp 실행에서 필요한 memberService 인터페이스에 AppConfig에서 설정한 MemoryMemberRepository를 주입한 memberService 객체를 생성한다.
<img width="1226" alt="스크린샷 2022-12-18 오후 9 58 57" src="https://user-images.githubusercontent.com/96857599/208299746-4779bf30-4640-4f94-b6b2-ee2f8fc20af6.png">

- OrderApp 실행에서 필요한 memberService 인터페이스, orderService 인터페이스에 AppConfig에서 설정한 MemoryMemberRepository를 주입한 memberService 객체와 FixDiscountPolicy를 주입한 orderService를 생성 한다.

#### Junit 테스트 DI 변경 후 실행

- 테스트의 가장 처음에 memberService를 AppConfig에서 가져온다.
<img width="1043" alt="스크린샷 2022-12-18 오후 10 12 36" src="https://user-images.githubusercontent.com/96857599/208300314-58aac663-9bdb-4d62-98a3-d8120de52d71.png">

- 테스트의 가장 처음에 memberService와 orderService를 AppConfig에서 가져온다.
<img width="1043" alt="스크린샷 2022-12-18 오후 10 14 16" src="https://user-images.githubusercontent.com/96857599/208300379-4f0abee7-e2b6-4312-adb2-228b1f574802.png">

### AppConfig 리팩터링
- 현재 AppConfig를 보면 **중복**이 있고, **역할**에 따른 **구현**이 잘 안 보인다.

기대하는 그림
<img width="639" alt="스크린샷 2022-12-18 오후 10 18 48" src="https://user-images.githubusercontent.com/96857599/208300593-a3085576-7900-4209-842f-07f84f15ed2f.png">

리팩터링 전
<img width="1321" alt="스크린샷 2022-12-18 오후 10 19 23" src="https://user-images.githubusercontent.com/96857599/208300613-223650da-9731-42e5-a8c2-97f0250caf7b.png">

**TIP💡 cmd + option + M을 누르면 method를 추가할 수 있다.**

리팩토링 후
<img width="1121" alt="스크린샷 2022-12-18 오후 10 25 39" src="https://user-images.githubusercontent.com/96857599/208300873-cc288d73-4a27-4701-9841-8c596803f695.png">

- new MemoryMemberRepository()이 부분이 중복 제거되었다. 이제 MemoryMemberRepository를 다른 구현체로 변경할 때 한 부분만 변경하면 된다.
- AppConfig를 보면 역할과 구현 클래스가 한눈에 들어온다. 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악할 수 있다.

### 새로운 구조와 할인 정책 적용

- AppConfig의 등장으로 애플리케이션이 크게 사용 영역과, 객체를 생성하고 구성(Configuration)하는 영역으로 분리되었다.

<img width="640" alt="스크린샷 2022-12-18 오후 10 29 55" src="https://user-images.githubusercontent.com/96857599/208301072-d7b03eef-989b-4867-9463-c2b947e782f3.png">

<img width="1297" alt="스크린샷 2022-12-18 오후 10 31 04" src="https://user-images.githubusercontent.com/96857599/208301104-ad8d27bc-7b1e-4879-a8b5-147454559f48.png">

- AppConfig에서 할인 정책 역할을 담당하는 구현을 FixDiscountPolicy 객체로 변경했다.
- 이제 할인 정책을 변경해도, 애플리케이션의 구성 역할을 담당하는 AppConfig만 변경하면 된다. 클라이언트 코드인 OrderServiceImpl를 포함해서 사용 영역의 어떤 코드도 변경할 필요가 없다.
- 구성 영역은 당연히 변경된다. 구성 역할을 담당하는 AppConfig를 애플리케이션이라는 공연의 기획자로 생각하자. 공연 기획자는 공연 참여자인 구현 객체들을 모두 알아야 한다.

### 좋은 객체 지향 설계의 5가지 원칙 적용

여기서 3가지 SRP, DIP, OCP 적용
#### SRP 단일 책임 원칙
**한 클래스는 하나의 책임만 가져야 한다.**

- 클라이언트 객체는 직접 구현 객체를 생성하고, 연결하고, 실행하는 다양한 책임을 가지고 있음
- SRP 단일 책임 원칙을 따르면서 관심사를 분리함
- 구현 객체를 생성하고 연결하는 책임은 AppConfig가 담당
- 클라이언트 객체는 실행하는 책임만 담당


#### DIP 의존관계 역전 원칙
**프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.” 의존성 주입은 이 원칙을 따르는 방법 중 하나다.**

- 새로운 할인 정책을 개발하고, 적용하려고 하니 클라이언트 코드도 함께 변경해야 했다. 왜냐하면 기존 클라이언트 코드(OrderServiceImpl)는 DIP를 지키며 DiscountPolicy 추상화 인터페이스에 의존하는 것 같았지만, FixDiscountPolicy 구체화 구현 클래스에도 함께 의존했다.
- 클라이언트 코드가 DiscountPolicy 추상화 인터페이스에만 의존하도록 코드를 변경했다.
- 하지만 클라이언트 코드는 인터페이스만으로는 아무것도 실행할 수 없다.
- AppConfig가 FixDiscountPolicy 객체 인스턴스를 클라이언트 코드 대신 생성해서 클라이언트 코드에 의존관계를 주입했다. 이렇게해서 DIP 원칙을 따르면서 문제도 해결했다.


#### OCP
**소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.**

- 다형성 사용하고 클라이언트가 DIP를 지킴
- 애플리케이션을 사용 영역과 구성 영역으로 나눔
- AppConfig가 의존관계를 FixDiscountPolicy RateDiscountPolicy 로 변경해서 클라이언트 코드에 주입하므로 클라이언트 코드는 변경하지 않아도 됨
- 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀 있다!


### IoC, DI, 그리고 컨테이너

#### 제어의 역전 IoC(Inversion of Control)
- 기존 프로그램은 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 생성하고, 연결하고, 실행했다. 한마디로 구현 객체가 프로그램의 제어 흐름을 스스로 조종했다. 개발자 입장에서는 자연스러운 흐름이다.
- 반면에 AppConfig가 등장한 이후에 구현 객체는 자신의 로직을 실행하는 역할만 담당한다. 프로그램의 제어 흐름은 이제 AppConfig가 가져간다. 예를 들어서 OrderServiceImpl은 필요한 인터페이스들을 호출하지만 어떤 구현 객체들이 실행될지 모른다.
- 프로그램에 대한 제어 흐름에 대한 권한은 모두 AppConfig가 가지고 있다. 심지어 OrderServiceImpl 도 AppConfig가 생성한다. 그리고 AppConfig는 OrderServiceImpl이 아닌 OrderService 인터페이스의 다른 구현 객체를 생성하고 실행할 수도 있다. 그런 사실도 모른체 OrderServiceImpl은 묵묵히 자신의 로직을 실행할 뿐이다.
- 이렇듯 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부(AppConfig)에서 관리하는 것을 제어의 역전(IoC)이라 한다.


#### 프레임워크 vs 라이브러리
- 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞다. (JUnit)
<img width="1007" alt="스크린샷 2022-12-19 오후 1 12 29" src="https://user-images.githubusercontent.com/96857599/208346119-48c9c1c5-a568-499a-a43d-74f3a81c1533.png">

- 반면에 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 프레임워크가 아니라 라이브러리다.


#### 의존관계 주입 DI(Dependency Injection)
- OrderServiceImpl 은 DiscountPolicy 인터페이스에 의존한다. 실제 어떤 구현 객체가 사용될지는
모른다.
- 의존관계는 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리해서 생각해야 한다.


#### 정적인 클래스 의존관계
클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있다. 정적인 의존관계는 애플리케이션을 실행하지 않아도 분석할 수 있다. 클래스 다이어그램을 보자
OrderServiceImpl은 MemberRepository, DiscountPolicy에 의존한다는 것을 알 수 있다.
그런데 이러한 클래스 의존관계 만으로는 실제 어떤 객체가 OrderServiceImpl에 주입 될지 알 수 없다.
- 클래스 다이어그램
<img width="633" alt="스크린샷 2022-12-19 오후 1 16 47" src="https://user-images.githubusercontent.com/96857599/208346532-fe9f4a64-bd29-442f-8050-317affff4857.png">


#### 동적인 객체 인스턴스 의존 관계
애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존관계이다.

<img width="641" alt="스크린샷 2022-12-19 오후 1 20 51" src="https://user-images.githubusercontent.com/96857599/208346910-1119d0ef-ac9f-42a4-a890-8abebbd6ec77.png">

#### IoC 컨테이너, DI 컨테이너
- AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너 또는 DI 컨테이너라 한다.
- 의존관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라 한다.
- 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 한다.

## 스프링으로의 전환

1. AppConfig에서 @Configuration을 붙임으로써 애플리케이션의 구성, 설정 정보를 나타내는 것을 알린다.
2. @Bean을 각각의 메소드에 붙이면 스프링 컨테이너에 등록됨.
<img width="1406" alt="스크린샷 2022-12-19 오후 1 35 01" src="https://user-images.githubusercontent.com/96857599/208348617-299723d9-b43d-4b83-b21a-fbb817f762f4.png">

3. MemberApp에서 spring 컨테이너를 통해 위에서 등록한 메소드를 찾아 실행한다.

<img width="1406" alt="스크린샷 2022-12-19 오후 1 34 40" src="https://user-images.githubusercontent.com/96857599/208348527-b5016600-3a4c-43e3-a52d-e59c01b1f3ca.png">

3-1. 등록된 내역을 확인할 수 있다.

<img width="1363" alt="스크린샷 2022-12-19 오후 1 36 26" src="https://user-images.githubusercontent.com/96857599/208348864-90814507-0c6b-432c-90b3-b3b41f8645e3.png">

4. OrderApp에서도 마찬가지다.
<img width="1373" alt="스크린샷 2022-12-19 오후 1 42 00" src="https://user-images.githubusercontent.com/96857599/208349437-7546c805-96dd-4f04-a166-12eaf8363b64.png">

#### 스프링 컨테이너
- ApplicationContext를 스프링 컨테이너라 한다.
- 기존에는 개발자가 AppConfig를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.
- 스프링 컨테이너는 @Configuration이 붙은 AppConfig를 설정(구성) 정보로 사용한다. 여기서 @Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다. 이렇게 스프링 컨테이너에 등록된 객체를 **스프링 빈**이라 한다.
- 스프링 빈은 @Bean 이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다. ( memberService , orderService )
- 이전에는 개발자가 필요한 객체를 AppConfig를 사용해서 직접 조회했지만, 이제부터는 스프링 컨테이너를 통해서 필요한 스프링 빈(객체)를 찾아야 한다. 스프링 빈은 applicationContext.getBean() 메서드를 사용해서 찾을 수 있다.
- 기존에는 개발자가 직접 자바코드로 모든 것을 했다면 이제부터는 스프링 컨테이너에 객체를 스프링 빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경되었다.

- 코드가 약간 더 복잡해진 것 같은데, 스프링 컨테이너를 사용하면 어떤 장점이 있을까?????

### 스프링 컨테이너와 스프링 빈

```java
//스프링 컨테이너 생성
ApplicationContext applicationContext =
                            new
    AnnotationConfigApplicationContext(AppConfig.class);
```
- ApplicationContext 를 스프링 컨테이너라 한다.
- ApplicationContext 는 인터페이스이다.
- 스프링 컨테이너는 XML을 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스로 만들 수 있다.
- 직전에 AppConfig 를 사용했던 방식이 애노테이션 기반의 자바 설정 클래스로 스프링 컨테이너를 만든
것이다.
- 자바 설정 클래스를 기반으로 스프링 컨테이너( ApplicationContext )를 만들어보자.
  - new AnnotationConfigApplicationContext(AppConfig.class);
  - 이 클래스는 ApplicationContext 인터페이스의 구현체이다.
  
  
> 참고: 더 정확히는 스프링 컨테이너를 부를 때 BeanFactory, ApplicationContext로 구분해서 이야기한다. 이 부분은 뒤에서 설명하겠다. BeanFactory를 직접 사용하는 경우는 거의 없으므로 일반적으로 ApplicationContext를 스프링 컨테이너라 한다.

#### 스프링 컨테이너 생성 과정

1. 스프링 컨테이너 생성
<img width="526" alt="스크린샷 2022-12-19 오후 10 21 40" src="https://user-images.githubusercontent.com/96857599/208435345-8d9eebb3-cacd-461e-b8f4-c2300dfbd82a.png">
- new AnnotationConfigApplicationContext(AppConfig.class)
- 스프링 컨테이너를 생성할 때는 구성 정보를 지정해주어야 한다.
- 여기서는 AppConfig.class 를 구성 정보로 지정했다.

2. 스프링 빈 등록
<img width="526" alt="스크린샷 2022-12-19 오후 10 22 24" src="https://user-images.githubusercontent.com/96857599/208435476-fddebc00-9e57-42e9-a008-36506cdc0a02.png">

- 스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록한다.

**빈 이름**

- 빈 이름은 메서드 이름을 사용한다.
- 빈 이름을 직접 부여할 수 도 있다.
  - @Bean(name="memberService2")
  
> 주의: 빈 이름은 항상 다른 이름을 부여해야 한다. 같은 이름을 부여하면, 다른 빈이 무시되거나, 기존 빈을 덮어버리거나 설정에 따라 오류가 발생한다.

3. 스프링 빈 의존관계 설정 - 준비
<img width="528" alt="스크린샷 2022-12-19 오후 10 23 36" src="https://user-images.githubusercontent.com/96857599/208435676-b4995556-d910-40b3-b9f3-81d51a8e29aa.png">

4. 스프링 빈 의존관계 설정 - 완료
<img width="527" alt="스크린샷 2022-12-19 오후 10 23 49" src="https://user-images.githubusercontent.com/96857599/208435718-9b790dba-763a-46cd-9d84-61c3d10fffb3.png">

- 스프링 컨테이너는 설정 정보를 참고해서 의존관계를 주입(DI)한다.
- 단순히 자바 코드를 호출하는 것 같지만, 차이가 있다. 이 차이는 뒤에 싱글톤 컨테이너에서 설명한다.


**참고**
스프링은 빈을 생성하고, 의존관계를 주입하는 단계가 나누어져 있다. 그런데 이렇게 자바 코드로 스프링 빈을 등록하면 생성자를 호출하면서 의존관계 주입도 한번에 처리된다. 여기서는 이해를 돕기 위해 개념적으로 나누어 설명했다. 자세한 내용은 의존관계 자동 주입에서 다시 설명하겠다.


### 컨테이너에 등록된 모든 빈 조회

1. 스프링 컨테이너에 실제 스프링 빈들이 잘 등록되었는지 확인.

**TIP💡 리스트 형식의 객체가 있을 때, iter + tap을 누르면 for문이 자동 생성된다.

- 전체 빈 확인
<img width="1235" alt="스크린샷 2022-12-19 오후 10 44 03" src="https://user-images.githubusercontent.com/96857599/208439404-b6ce1bf8-66ec-4187-8c5b-a217680a8665.png">

- 내가 입력한 스프링 빈만 보고싶을 때(혹은 스프링 내부에서 사용하는 빈을 보고싶을 때는 Role ROLE_INFRASTRUCTURE)

<img width="1235" alt="스크린샷 2022-12-19 오후 10 45 53" src="https://user-images.githubusercontent.com/96857599/208439740-64e636a2-5b2d-4c40-b0a4-c99e64a4feae.png">

- ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회한다.
- ac.getBean() : 빈 이름으로 빈 객체(인스턴스)를 조회한다.

### 




