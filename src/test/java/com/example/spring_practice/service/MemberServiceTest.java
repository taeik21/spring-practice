package com.example.spring_practice.service;

import com.example.spring_practice.domain.Member;
import com.example.spring_practice.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemoryMemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach
    void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("홍길동");

        memberService.join(member);

        Member findMember = memberService.findOne(member.getId()).get();
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void 중복_회원_예외() {
        Member member = new Member();
        member.setName("홍길동");
        memberService.join(member);

        Member member2 = new Member();
        member2.setName("홍길동");

        IllegalStateException e = assertThrows(
                IllegalStateException.class, ()-> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("중복된 회원 이름입니다");
    }
}