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
    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
    //    return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
}
