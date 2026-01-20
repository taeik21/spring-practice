package com.example.spring_practice;

import com.example.spring_practice.repository.MemberRepository;
import com.example.spring_practice.repository.MemoryMemberRepository;
import com.example.spring_practice.service.MemberService;
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
