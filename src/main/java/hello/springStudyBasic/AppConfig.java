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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
