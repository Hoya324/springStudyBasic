package hello.springStudyBasic;


import hello.springStudyBasic.discount.DiscountPolicy;
import hello.springStudyBasic.discount.FixDiscountPolicy;
import hello.springStudyBasic.discount.RateDiscountPolicy;
import hello.springStudyBasic.member.MemberRepository;
import hello.springStudyBasic.member.MemberService;
import hello.springStudyBasic.member.MemberServiceImpl;
import hello.springStudyBasic.member.MemoryMemberRepository;
import hello.springStudyBasic.order.OrderService;
import hello.springStudyBasic.order.OrderServiceImpl;

// 전체를 기획 관리하는 클래스
public class AppConfig {


    
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
