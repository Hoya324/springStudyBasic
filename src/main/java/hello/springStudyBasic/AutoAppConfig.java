package hello.springStudyBasic;

import hello.springStudyBasic.member.MemberRepository;
import hello.springStudyBasic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 기존에 있던 AppConfig, TestConfig 등의 중복 방지를 위해 스프링 빈에 등록을 막는 것
@ComponentScan(
        // 해당 패키지부터 탐색을 시작할 수 있도록 설정
        basePackages = "hello.springStudyBasic",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
