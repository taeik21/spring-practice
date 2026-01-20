package com.example.spring_practice.repository;

import com.example.spring_practice.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void tearDown() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("홍길동");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        Member member = new Member();
        member.setName("홍길동");
        memberRepository.save(member);

        Member member1 = new Member();
        member.setName("김철수");
        memberRepository.save(member1);

        Member result = memberRepository.findByName(member.getName()).get();

        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    void findAll() {
        Member member = new Member();
        member.setName("홍길동");
        memberRepository.save(member);

        Member member1 = new Member();
        member.setName("김철수");
        memberRepository.save(member1);

        List<Member> memberList = memberRepository.findAll();

        Assertions.assertThat(memberList.size()).isEqualTo(2);
    }
}