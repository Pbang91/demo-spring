package com.example.demo.domain.member.service;

import com.example.demo.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Long join(Member member);

    List<Member> findMembers();

    Optional<Member> findOne(Long id);
}
