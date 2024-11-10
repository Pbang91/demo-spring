package com.example.demo.domain.member.service;

import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.domain.member.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemberServiceImplTest {
    private MemberService memberService;
    private MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hero");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findedMemeber = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findedMemeber.getName());
    }

    @Test
    public void validateDuplicatedMemberException() {
        // given
        Member member1 = new Member();
        member1.setName("m1");

        Member member2 = new Member();
        member2.setName("m1");

        memberService.join(member1);

        // when + then
        try {
            memberService.join(member2);
            Assertions.fail("성공");
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("존재 회원");
        }

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}