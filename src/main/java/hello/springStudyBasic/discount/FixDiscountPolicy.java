package hello.springStudyBasic.discount;

import hello.springStudyBasic.member.Grade;
import hello.springStudyBasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인


    @Override
    public int discount(Member member, int price) {

        // enum 형식은 == 쓰는게 맞음.
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
