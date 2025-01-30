package com.example.jpa.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
