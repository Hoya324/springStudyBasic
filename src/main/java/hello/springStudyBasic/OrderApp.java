package hello.springStudyBasic;

import hello.springStudyBasic.member.Grade;
import hello.springStudyBasic.member.Member;
import hello.springStudyBasic.member.MemberService;
import hello.springStudyBasic.member.MemberServiceImpl;
import hello.springStudyBasic.order.Order;
import hello.springStudyBasic.order.OrderService;
import hello.springStudyBasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}

