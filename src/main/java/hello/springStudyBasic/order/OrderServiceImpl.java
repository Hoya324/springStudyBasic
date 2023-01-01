package hello.springStudyBasic.order;


import hello.springStudyBasic.discount.DiscountPolicy;
import hello.springStudyBasic.member.Member;
import hello.springStudyBasic.member.MemberRepository;
import hello.springStudyBasic.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 필요한 클래스를 불러올 때 private final로 불러오는 이유: 생성자 기반 DI (생성자 주입: Constructor Injection)
    // @Autowired와 같은 방식이지만 순환 참조 방지, 테스트 용이, final 선언 가능으로 인한 불변성 보장 등의 장점이 있다.


//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;


//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 할인에 대한 부분은 discountPolicy만 의존하면되기 때문에 단일체계원칙을 잘 지킨 설계다.
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
