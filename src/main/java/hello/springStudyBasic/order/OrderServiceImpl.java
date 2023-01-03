package hello.springStudyBasic.order;


import hello.springStudyBasic.annotation.MainDiscountPolicy;
import hello.springStudyBasic.discount.DiscountPolicy;
import hello.springStudyBasic.member.Member;
import hello.springStudyBasic.member.MemberRepository;
import hello.springStudyBasic.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
