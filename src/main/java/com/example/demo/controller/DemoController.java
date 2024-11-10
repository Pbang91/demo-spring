package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/demo-mvc")
    public String whatMvc(@RequestParam(value = "n", required = false) String name, Model model) {
        model.addAttribute("name", name);

        return "demo-template";
    }

    @GetMapping("/demo-str")
    @ResponseBody
    public String whatStr(@RequestParam(value = "n", required = true) String name) {
        /*
         @ResponseBody를 사용하면  ViewResolver 대신 HttpMessageConverter 동작
         기본 문차처리: StringHttpMessageConverter
         기본 객체처리: MappingJsckson2HttpMessageConverter
         */

        return "name is " + name;
    }

    @GetMapping("/demo-json")
    @ResponseBody
    public JJ whatJson(@RequestParam(value = "n", required = true) String name) {
        JJ jj = new JJ();

        jj.setName(name);

        return jj;
    }

    public class JJ {
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
