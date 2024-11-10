package com.example.demo.domain.member.repository;

import com.example.demo.domain.member.entity.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("newMember");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("otherMember");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("doneMember");
        repository.save(member2);

        Member result = repository.findByName("otherMember").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("otherMember");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("doneMember");
        repository.save(member2);

        List<Member> results = repository.findALl();

        assertThat(results.size()).isEqualTo(2);
    }
}
