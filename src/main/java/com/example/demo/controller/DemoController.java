package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/demo")
    public String what (Model model) {
        model.addAttribute("data", "Demo!!!!");

        /*
            1. return 선언으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리해줌
            2. resource:templates/{ViewName}.html - thymeleaf 엔진 처리
            3. 대소문자를 가리지 않음
         */
//        return "other"; // 이건 other.html
//        return "demo"; // 이건 demo.html
        return "Demo"; // 이것도 demo.html
    }
}
