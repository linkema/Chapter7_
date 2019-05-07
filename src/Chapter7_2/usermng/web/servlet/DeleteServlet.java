package Chapter7_2.usermng.web.servlet;

import Chapter7_2.usermng.domain.User;
import Chapter7_2.usermng.service.GmUserService;
import Chapter7_2.usermng.service.UserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        GmUserService gmUserService=new GmUserService();
        try {
            gmUserService.deleteUser(username);
            ArrayList<User> list=gmUserService.showAllUser();
            request.setAttribute("list",list);
            request.getRequestDispatcher("Chapter7_2/update.jsp").forward(request,response);
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("Chapter7_2/gmIndex.jsp").forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
