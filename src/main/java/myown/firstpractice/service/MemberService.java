package myown.firstpractice.service;

import myown.firstpractice.domain.Member;
import myown.firstpractice.repository.MemberRepository;
import myown.firstpractice.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){ //이부분은 왜만드는지는 알겠는데 동작과정이 잘 이해가 안댐.
        this.memberRepository = memberRepository;
    }
    public Long join(Member member){//회원가입

        Optional<Member> result = memberRepository.findByName(member.getName()); //중복체크
        result.ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
        return member.getId();

    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }








}
