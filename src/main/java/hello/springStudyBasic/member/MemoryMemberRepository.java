package hello.springStudyBasic.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    // 원래라면 HashMap이 아닌, concurrentHashMap이 적합함. HashMap은 멀티 쓰레드 환경에서 사용할 수 없기 때문.(동시성 이슈)
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
