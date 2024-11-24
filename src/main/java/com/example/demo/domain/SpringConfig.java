package com.example.demo.domain;

import com.example.demo.domain.aop.TimeTraceAop;
import com.example.demo.domain.member.repository.JpaMemberRepository;
import com.example.demo.domain.member.repository.MemberRepository;
import com.example.demo.domain.member.repository.MemoryMemberRepository;
import com.example.demo.domain.member.service.MemberService;
import com.example.demo.domain.member.service.MemberServiceImpl;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
정형화되지 않거나, 상황에 따라 구현 클래스를 변경해야 한다면,
config를 통해 스프링 빈으로 등록한다
*/
@Configuration
public class SpringConfig {
//    private final EntityManager em;
    private final MemberRepository memberRepository;

//    @Autowired
//    public  SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
        return new MemberServiceImpl(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JpaMemberRepository(em);
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
