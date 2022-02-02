package hello.servlet.web.frontcontoller.v2;

import hello.servlet.web.frontcontoller.MyView;
import hello.servlet.web.frontcontoller.v1.ControllerV1;
import hello.servlet.web.frontcontoller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontoller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontoller.v1.controller.MemberSaveControllerV1;
import hello.servlet.web.frontcontoller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontoller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontoller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerV2Map = new HashMap<>();

    public FrontControllerServletV2() {
        controllerV2Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerV2Map.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerV2Map.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FontControllerServletV2.service");

        String requestURI = request.getRequestURI();

        ControllerV2 controller = controllerV2Map.get(requestURI); // uri 는 url의 상위 개념
        // 만약 front Controller가 없었으면 이 조건문을 각 객체에 하나하나 추가해야겠지?
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view = controller.process(request, response); // Map으로 담긴 controller 객체의 process 수행
        view.render(request, response); // veiw 반환
    }
}
