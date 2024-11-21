package com.example.demo.domain.member.controller;

import com.example.demo.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    /*
    @Autowired를 통한 DI는 스프링이 관리하는 객체에서만 동작한다.
    스프링 빈으로 등록하지 않고 직접 생성한 객체에서는 동작하지 않는다
    사실 당연 :)..
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
