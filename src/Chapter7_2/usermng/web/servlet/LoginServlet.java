package Chapter7_2.usermng.web.servlet;

import Chapter7_2.usermng.domain.User;
import Chapter7_2.usermng.service.GmUserService;
import Chapter7_2.usermng.service.UserException;
import Chapter7_2.usermng.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 处理登录请求
 * 它是web层，所有与web相关的内容可以出现在这里！
 * 例如；request、repsonse、ServletContext，它们只能出现在web层！
 * @author mlk
 *
 */
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		// 依赖service
		if ("admin".equals(username)) {
			GmUserService gmUserService=new GmUserService();
			User user = new User(username, request.getParameter("password"));
			try {
				gmUserService.login(user);
				request.getSession().setAttribute("session_user", user);
				// 重定向到index.jsp
				response.sendRedirect(request.getContextPath() + "/Chapter7_2/gMindex.jsp");
			} catch (UserException e) {
				request.setAttribute("msg", e.getMessage());
				request.setAttribute("form", user);
				request.getRequestDispatcher("Chapter7_2/login.jsp").forward(request, response);
				return;
			}
		} else {
			UserService userService = new UserService();

			/*
			 * 1. 一句封装
			 */
			//User form = CommonUtils.toBean(request.getParameterMap(), User.class);
			User user = new User(username, request.getParameter("password"));
			try {
				userService.login(user);
				/*
				 * 2. 输入校验（略）
				 */
				/*
				 * 3. 调用userService的login()方法，完成业务
				 */
				/*
				 * 执行到这里，说明登录成功了
				 */
				// 保存当前用户到session中
				request.getSession().setAttribute("session_user", user);
				// 重定向到index.jsp
				response.sendRedirect(request.getContextPath() + "/Chapter7_2/index.jsp");
			} catch (UserException e) {
				/*
				 * 执行到这里，说明登录失败
				 * 1. 保存异常信息、form，到reuqest域
				 * 2. 转发到login.jsp
				 */
				request.setAttribute("msg", e.getMessage());
				request.setAttribute("form", user);
				request.getRequestDispatcher("Chapter7_2/login.jsp").forward(request, response);
				return;
			}
		}
	}
}