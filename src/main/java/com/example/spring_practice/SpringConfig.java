package com.example.spring_practice;

import com.example.spring_practice.repository.JpaMemberRepository;
import com.example.spring_practice.repository.MemberRepository;
import com.example.spring_practice.repository.MemoryMemberRepository;
import com.example.spring_practice.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
}
