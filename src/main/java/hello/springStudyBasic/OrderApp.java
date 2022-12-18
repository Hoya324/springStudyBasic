package hello.springStudyBasic;

import hello.springStudyBasic.member.Grade;
import hello.springStudyBasic.member.Member;
import hello.springStudyBasic.member.MemberService;
import hello.springStudyBasic.member.MemberServiceImpl;
import hello.springStudyBasic.order.Order;
import hello.springStudyBasic.order.OrderService;
import hello.springStudyBasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}

