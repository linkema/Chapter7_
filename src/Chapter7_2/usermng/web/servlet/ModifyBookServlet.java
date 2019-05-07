package Chapter7_2.usermng.web.servlet;

import Chapter7_2.usermng.dao.GMUserDao;
import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.service.GmUserService;
import Chapter7_2.usermng.service.UserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyBookServlet")
public class ModifyBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GmUserService gmUserService=new GmUserService();
        Book form= null;
        try {
            form = gmUserService.searchBook(request.getParameter("id"));
        } catch (UserException e) {
            e.printStackTrace();
        }

        try {
            gmUserService.modifyBook(form);
            response.getWriter().print("恭喜，添加成功！");
            request.setAttribute("list",gmUserService.showAllBook());
            request.getRequestDispatcher("Chapter7_2/update2.jsp").forward(request,response);
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            // 转发到regist.jsp
            request.getRequestDispatcher("Chapter7_2/Modify_Book.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
