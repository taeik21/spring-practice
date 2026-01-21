package com.example.spring_practice.service;

import com.example.spring_practice.domain.Member;
import com.example.spring_practice.repository.JpaMemberRepository;
import com.example.spring_practice.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;

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
