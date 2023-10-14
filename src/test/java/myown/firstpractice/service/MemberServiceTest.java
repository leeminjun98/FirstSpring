package myown.firstpractice.service;

import myown.firstpractice.domain.Member;
import myown.firstpractice.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach  //실패
    public void beforeEach(){ //왜 만드는지는 이해되는데 이렇게 하면 인스턴스가 하나만 사용된다는건가.
                                //외부에서 레포지토리를 받아오니깐 같은 레포지토리를 사용한다는것.
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("leeminjun");
        //when
        Long id = memberService.join(member);
        //then
        Member result = memberService.findOne(id).get();
        Assertions.assertThat(result.getName()).isEqualTo(member.getName());

    }

    @Test
    void 중복체크(){
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        try{
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        }catch(IllegalStateException e){

            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        }

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}