package Chapter7_2.usermng.web.servlet;

import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.service.GmUserService;
import Chapter7_2.usermng.service.UserException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String bookID=request.getParameter("id");
        String bookName=request.getParameter("name");
        String bookAu=request.getParameter("author");
        String bookPr=request.getParameter("price");
        String bookNote=request.getParameter("note");
        Book book=new Book(bookID,bookName,bookAu,bookPr,bookNote);
        GmUserService gmUserService=new GmUserService();
        try {
            gmUserService.addBook(book);
            response.getWriter().print("恭喜，添加成功！");
            request.setAttribute("list",gmUserService.showAllBook());
            request.getRequestDispatcher("Chapter7_2/update2.jsp").forward(request,response);
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            // 转发到regist.jsp
            request.getRequestDispatcher("Chapter7_2/Insert_Book.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
