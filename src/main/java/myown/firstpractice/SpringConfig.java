package myown.firstpractice;

import myown.firstpractice.repository.MemberRepository;
import myown.firstpractice.repository.MemoryMemberRepository;
import myown.firstpractice.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
