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


// gradle 명령어로 build 하기
/**
 * 프로젝트 ROOT 에서 ./gradlew build 실행
 * builc 폴더 생성됨
 * libs 폴더 밑에 .jar 파일 생성됨
 * java -jar *-SNAPSHOT.jar 로 자바 파일 실행
 *
 * */
