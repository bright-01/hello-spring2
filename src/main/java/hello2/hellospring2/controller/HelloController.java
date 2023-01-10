package hello2.hellospring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    /**
     *
     * @ResponseBody 를 사용
     *     HTTP의 BODY에 문자 내용을 직접 반환
     *     viewResolver 대신에 HttpMessageConverter 가 동작
     *     기본 문자처리: StringHttpMessageConverter
     *     기본 객체처리: MappingJackson2HttpMessageConverter
     *     byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
     *
     */
    @GetMapping("hello-string")
    @ResponseBody
    // ResponseBody --> http body 응답에 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


// gradle 명령어로 build 하기
/**
 * 프로젝트 ROOT 에서 ./gradlew build 실행
 * builc 폴더 생성됨
 * libs 폴더 밑에 .jar 파일 생성됨
 * java -jar *-SNAPSHOT.jar 로 자바 파일 실행
 *
 *
 * 잘안되면
 * ./gradlew clean 후 build 하면 된다
 * */
