package Chapter7_2.usermng.web.servlet;

import Chapter7_2.usermng.domain.BorrowBook;
import Chapter7_2.usermng.domain.User;
import Chapter7_2.usermng.service.GmUserService;
import Chapter7_2.usermng.service.UserException;
import Chapter7_2.usermng.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BorrowBookServlet")
public class BorrowBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user= (User) request.getSession().getAttribute("session_user");
        String id=request.getParameter("id");
        String username=user.getUsername();
        BorrowBook form=new BorrowBook(username,id);
        UserService userService=new UserService();
        try {
            userService.borrowBook(form);
            response.getWriter().print("恭喜，添加成功！");
            response.sendRedirect(request.getContextPath() + "/Chapter7_2/userMenu.jsp");
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", user);
            request.getRequestDispatcher("Chapter7_2/Borrow_Book.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
