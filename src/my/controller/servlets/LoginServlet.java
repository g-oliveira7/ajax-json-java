package my.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.model.entities.User;

@WebServlet(name="login", urlPatterns = {"/pages/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Boolean logout = Boolean.valueOf(req.getParameter("logout")); 
		
		if (logout) {
			req.getSession().invalidate();
			resp.sendRedirect("../index.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		User user = new User();
		
		if (user.getLogin().equals(login) && user.getSenha().equals(senha)) {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("../index.jsp");
		}
		
	}
}
