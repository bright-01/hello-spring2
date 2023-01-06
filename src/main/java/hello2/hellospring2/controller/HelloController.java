package hello2.hellospring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        return "hello";
        // 컨트롤러에서 리턴 값으로 문자를 반환 하면
        // 뷰리졸버 ( viewResolver ) 가 화면을 찾아서 처리 한다
        // 스프링 부트 템플릿엔진 기본 viewName 매핑
        // resource:templates/ + {ViewName} + .html
    }
}