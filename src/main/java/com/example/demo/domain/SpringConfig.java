package com.example.demo.domain;

import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.domain.member.repository.MemoryMemberRepository;
import com.example.demo.domain.member.service.MemberService;
import com.example.demo.domain.member.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /*
     정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 한다면,
     config를 통해 스프링 빈으로 등록한다
     */

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
