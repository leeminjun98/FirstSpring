package myown.firstpractice.service;

import myown.firstpractice.domain.Member;
import myown.firstpractice.repository.MemberRepository;
import myown.firstpractice.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
