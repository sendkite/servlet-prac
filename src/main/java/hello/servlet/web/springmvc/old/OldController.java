package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("/springmvc/old-controller") // 스프링빈의 이름 url로 준거, handlerMapping에서 이 컨크롤러를 찾음 (by 스프링 빈의 이름으로 찾음 , 최우선으로는 @RequestMapping으로 찾음)
public class OldController implements Controller { // controller가 실행할 수 있는 인터페이스인지 스프링 핸들러 어댑터가 확인

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }
}
