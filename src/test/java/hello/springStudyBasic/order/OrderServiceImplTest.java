package hello.springStudyBasic.order;

import hello.springStudyBasic.discount.FixDiscountPolicy;
import hello.springStudyBasic.member.Grade;
import hello.springStudyBasic.member.Member;
import hello.springStudyBasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void creatOrder() {

        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order itemA = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }
}