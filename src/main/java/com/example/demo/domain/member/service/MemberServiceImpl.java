package com.example.demo.domain.member.service;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 중복 체크
     *
     * @param member
     */
    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("존재 회원");
                });
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicatedMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    /**
     * all members
     *
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findALl();
    }

    /**
     * get member by id
     *
     * @param id
     * @return
     */
    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }

}
