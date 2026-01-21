package com.example.spring_practice.repository;

import com.example.spring_practice.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaRepository
        extends JpaRepository<Member, Long>, MemberRepository {
    Optional<Member> findByName(String name);
}
