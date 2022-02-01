package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; // 해당 path는 브라우저에서 접근 불가, 컨트롤러를 통해서만 접근할 수 있다.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// 디스패처 : 컨트롤러에서 뷰로 이동할때 사용하는 것
        dispatcher.forward(request, response); // 서블릿에서 jsp를 호출하는 역할, 다른 서블릿이나 jsp를 서버 내부에서 다시 호출 할 수 있다.
        // redirect와 달리 서버 내부에서 일어나는 호출이기 때문에 클라에서는 1번의 호출임
    }
}
