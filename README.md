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

